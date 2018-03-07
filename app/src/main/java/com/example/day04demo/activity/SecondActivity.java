package com.example.day04demo.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.day04demo.R;
import com.example.day04demo.activity.adapter.MyPagerAdapter;
import com.example.day04demo.activity.fragment.LiebiaoFragment;
import com.example.day04demo.activity.fragment.ShoucangFragment;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {

    private TabLayout tab;
    private ViewPager vp;
    private List<Fragment> fragmentlist;
    private List<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initView();
        initData();
        initAdapter();
    }

    private void initAdapter() {
        MyPagerAdapter myPagerAdapter = new MyPagerAdapter(getSupportFragmentManager(), fragmentlist, list);
        tab.setupWithViewPager(vp);
        vp.setAdapter(myPagerAdapter);
    }
//共和国海关
    private void initData() {
        fragmentlist = new ArrayList<>();
        fragmentlist.add(new ShoucangFragment());
        fragmentlist.add(new LiebiaoFragment());

        list = new ArrayList<>();
        list.add("列表");
        list.add("收藏");
    }

    private void initView() {
        tab = (TabLayout) findViewById(R.id.tab);
        vp = (ViewPager) findViewById(R.id.vp);
    }
}
