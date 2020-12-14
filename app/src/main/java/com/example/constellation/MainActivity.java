package com.example.constellation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {
    RadioGroup mainRg;
    //声明四个按钮对应的Fragment对象
    Fragment starFrag,luckFrag,partnerFrag,meFrag;
    private FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainRg=findViewById(R.id.main_radioButton);
        //设置点击事件的监听，点击了那个单选按钮
        mainRg.setOnCheckedChangeListener(this);
        //创建碎片对象
        starFrag=new StarFragment();
        partnerFrag=new PartnerFragment();
        luckFrag=new LuckFragment();
        meFrag=new MeFragment();
        //加载到要替换的布局里，replace          add/hide.show
        addFragmentPage();
    }

    /*
    * @des 将主页当中的碎片一起加载进入布局，有用的显示，无用的隐藏嘿嘿嘿    * */
    private void addFragmentPage() {
        //1.创建碎片管理者对象
        manager = getSupportFragmentManager();
        //2.创建碎片处理事务的对象
        FragmentTransaction transaction = manager.beginTransaction();
        //3.将四个FRAGMENT统一添加到布局
        transaction.add(R.id.main_layout_center,starFrag);
        transaction.add(R.id.main_layout_center,partnerFrag);
        transaction.add(R.id.main_layout_center,luckFrag);
        transaction.add(R.id.main_layout_center,meFrag);
        //4.第一次只显示一个所以要隐藏其余的三个
        transaction.hide(partnerFrag);
        transaction.hide(luckFrag);
        transaction.hide(meFrag);
        //5.提交碎片改变后的事务
        transaction.commit();
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        FragmentTransaction transaction = manager.beginTransaction();
        switch (checkedId){
            case R.id.main_radioButton_star:
                transaction.hide(partnerFrag);
                transaction.hide(luckFrag);
                transaction.hide(meFrag);
                transaction.show(starFrag);
                transaction.commit();
                break;
            case R.id.main_radioButton_parnter:
                transaction.show(partnerFrag);
                transaction.hide(luckFrag);
                transaction.hide(meFrag);
                transaction.hide(starFrag);
                transaction.commit();
                break;
            case R.id.main_radioButton_luck:
                transaction.hide(partnerFrag);
                transaction.show(luckFrag);
                transaction.hide(meFrag);
                transaction.hide(starFrag);
                transaction.commit();
                break;
            case R.id.main_radioButton_me:
                transaction.hide(partnerFrag);
                transaction.hide(luckFrag);
                transaction.show(meFrag);
                transaction.hide(starFrag);
                transaction.commit();
                break;

        }
    }
}
