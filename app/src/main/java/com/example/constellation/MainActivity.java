package com.example.constellation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

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
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId){
            case R.id.main_radioButton_star:

                break;
            case R.id.main_radioButton_parnter:

                break;
            case R.id.main_radioButton_luck:

                break;
            case R.id.main_radioButton_me:

                break;

        }
    }
}
