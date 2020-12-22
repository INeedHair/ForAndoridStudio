package com.example.constellation.starfrag;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.LinearLayout;

import com.example.constellation.R;
import com.example.constellation.bean.StarBean;

import java.util.List;


/**
 * 表示星座的fragment
 * 宝座viewpager和gridview
 */
public class StarFragment extends Fragment {
    ViewPager starVp;
    GridView starGv;
    LinearLayout pointLayout;
    private List<StarBean.StarinfoBean> mDatas;
    private StarBaseAdapter starBaseAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_star, container, false);
        initView(view);

        //获取主界面传来的数据
        Bundle bundle=getArguments();
        StarBean infoBean= (StarBean) bundle.getSerializable("info");
        mDatas = infoBean.getStarinfo();

        //创建适配器
        starBaseAdapter = new StarBaseAdapter(getContext(), mDatas);
        starGv.setAdapter(starBaseAdapter);

        return view;
    }

    //进行初始化控件的操作
    private void initView(View view) {
        starVp=view.findViewById(R.id.starfrag_vp);
        starGv=view.findViewById(R.id.starfrag_gv);
        pointLayout=view.findViewById(R.id.starfrag_layout);
    }

}