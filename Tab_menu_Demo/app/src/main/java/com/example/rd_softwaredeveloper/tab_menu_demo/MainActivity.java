package com.example.rd_softwaredeveloper.tab_menu_demo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity implements ViewPager.OnPageChangeListener, TabHost.OnTabChangeListener
{
    private FragmentTabHost mTabHost;
    private LayoutInflater layoutInflater;
    private Class fragmentArray[] = { Fragment1.class, Fragment2.class };
    private int imageViewArray[] = { R.drawable.tab_home_btn, R.drawable.tab_view_btn };
    private String textViewArray[] = { "首頁", "分類"};
    private List<Fragment> list = new ArrayList<Fragment>();
    private ViewPager vp;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();//初始化控件
        initPage();//初始化頁面
    }

    //控件初始化控件
    private void initView()
    {
        vp = (ViewPager) findViewById(R.id.pager);

        /*
        實現 OnPageChangeListenver 接口，目的是監聽 Tab 選項的變化，然後通知 ViewPager 調適器切換頁面
        簡單來說，是為了讓 ViewPager 滑動的時候能夠帶著底部菜單連動
         */
        vp.addOnPageChangeListener(this);//設置頁面切換時的監聽器
        layoutInflater = LayoutInflater.from(this);//加載布局管理器

        //實體化 FrangmentTabHost 對象並進行初始化
        mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);//初始化 Tabhost
        mTabHost.setup(this, getSupportFragmentManager(), R.id.pager);//初始化 viewpager

        /*
        實現 setOnTabChangedListener 接口，目的是為了監聽介面切換，然後實現 TabHost 裡面圖片文字的選中狀態切換
        簡單來說就是為了當點擊下面菜單，上面的 ViewPage 能滑動到相對應的 Fragment
         */
        mTabHost.setOnTabChangedListener(this);
        int count = textViewArray.length;

        //新建 Tabspec 選項並設置 Tab 菜單欄位的內容和初始化對應的 Fragment
        for (int i = 0; i < count; i++)
        {
            // 給每個 Tab 按鈕設置標籤和圖標與文字
            TabHost.TabSpec tabSpec = mTabHost.newTabSpec(textViewArray[i]).setIndicator(getTabItemView(i));

            // 将Tab按钮添加进Tab选项卡中，并绑定Fragment
            // 將 Tab 按鈕添加進 Tab 選項中，並初始化給 Fragment
            mTabHost.addTab(tabSpec, fragmentArray[i], null);
            mTabHost.setTag(i);
            mTabHost.getTabWidget().getChildAt(i).setBackgroundResource(R.drawable.selector_tab_background); //設置 Tab 被選中的時候顏色改變
        }
    }

    //初始化 Fragment
    private void initPage()
    {
        Fragment1 fragment1 = new Fragment1();
        Fragment2 fragment2 = new Fragment2();

        list.add(fragment1);
        list.add(fragment2);

        //初始化 Fragment 調配器
        vp.setAdapter(new MyFragmentAdapter(getSupportFragmentManager(), list));
        mTabHost.getTabWidget().setDividerDrawable(null);
    }

    private View getTabItemView(int i)
    {
        //將 xml 布局轉換為 view 對象
        View view = layoutInflater.inflate(R.layout.tab_content, null);
        //利用 View 對象，找到佈局中的組件，並設定內容，返回
        ImageView mImageView = (ImageView) view.findViewById(R.id.tab_imageview);
        TextView mTextView = (TextView) view.findViewById(R.id.tab_textview);
        mImageView.setBackgroundResource(imageViewArray[i]);
        mTextView.setText(textViewArray[i]);
        return view;
    }

    @Override
    public void onPageScrollStateChanged(int arg0)
    {

    }

    /*
    arg0 = 0 表示無動作
    arg0 = 1 表示正在滑動中
    arg0 = 2 表示滑動完畢
    */

    @Override
    public void onPageScrolled(int arg0, float arg1, int arg2)
    {

    }

    //表示在前一個頁面滑動到最後一個頁面時，在前一個頁面滑動前調用的方法
    @Override
    public void onPageSelected(int arg0)
    {
        //arg0 表示你當前選中的頁面位置 Postion ，這事件是在你頁面跳轉完畢的時候調用的。
        TabWidget widget = mTabHost.getTabWidget();
        int oldFocusability = widget.getDescendantFocusability();
        widget.setDescendantFocusability(ViewGroup.FOCUS_BLOCK_DESCENDANTS);//設置 View 覆蓋子類別控制物件並且直接獲得焦點
        mTabHost.setCurrentTab(arg0);//根據位置 Postion 設置當前的 Tab
        widget.setDescendantFocusability(oldFocusability);//設置取消分隔線
    }

    @Override
    public void onTabChanged(String tabId)
    {
        //Tab 改變時調用
        int position = mTabHost.getCurrentTab();
        vp.setCurrentItem(position);//把選中的 Tab 的位置賦予調適器，讓他控制頁面切換
    }
}
