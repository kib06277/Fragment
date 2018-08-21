package com.example.rd_softwaredeveloper.tab_menu_demo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Carson_Ho on 16/5/23.
 */
public class MyFragmentAdapter extends FragmentPagerAdapter
{
    List<Fragment> list;
    public MyFragmentAdapter(FragmentManager fm,List<Fragment> list)
    {
        super(fm);
        this.list=list;
    }

    //構造方法，方便賦予調用
    @Override
    public Fragment getItem(int arg0)
    {
        return list.get(arg0);
    }

    //根據 Item 的位置返回對應位置的 Fragment ，綁定 item 和 Fragment
    @Override
    public int getCount()
    {
        return list.size(); //設置 Item 數量
    }
}


