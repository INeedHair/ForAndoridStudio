package com.example.constellation.luckfrag;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.constellation.R;
import com.example.constellation.bean.StarBean;

import java.util.List;


/**
 * 运势界面
 */
public class LuckFragment extends Fragment {
    GridView luckGv;
    List<StarBean.StarinfoBean> mDatas;
    private LuckBaseAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view =inflater.inflate(R.layout.fragment_luck, container, false);
        luckGv=view.findViewById(R.id.luckfrag_gv);
        //        获取数据源
        Bundle bundle = getArguments();
        StarBean infobean = (StarBean) bundle.getSerializable("info");
        mDatas = infobean.getStarinfo();

        //       创建适配器对象
        adapter = new LuckBaseAdapter(getContext(), mDatas);
//        设置适配器
        luckGv.setAdapter(adapter);

        return view;
    }

}
