package com.example.day04demo.activity.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by 王宇辉 on 2018/3/6.
 */

public class MyPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragmentlist;
    private List<String> list;

    public MyPagerAdapter(FragmentManager fm, List<Fragment> fragmentlist, List<String> list) {
        super(fm);
        this.fragmentlist = fragmentlist;
        this.list = list;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentlist.get(position);
    }

    @Override
    public int getCount() {
        return fragmentlist.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return list.get(position);
    }
}
