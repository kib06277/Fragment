package com.hfad.tablayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import android.os.Bundle;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener, TabLayout.OnTabSelectedListener
{
    private ViewPager viewPager;
    private TabLayout tabLayout;

    private Fragment1 fragment1 = new Fragment1();
    private Fragment2 fragment2 = new Fragment2();
    private Fragment3 fragment3 = new Fragment3();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);

        //註冊監聽
        viewPager.addOnPageChangeListener(this);
        tabLayout.addOnTabSelectedListener(this);

        //添加適配器，在 ViewPager 裡面引用 Fragment
        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager())
        {
            @Override
            public Fragment getItem(int position)
            {
                switch (position)
                {
                    case 0:
                        return fragment1;
                    case 1:
                        return fragment2;
                    case 2:
                        return fragment3;
                }
                return null;
            }

            @Override
            public int getCount()
            {
                return 3;
            }
        });

    }

    @Override
    public void onTabSelected(TabLayout.Tab tab)
    {
        //TabLayout 裡的 TabItem 被點選觸發
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab)
    {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab)
    {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels)
    {

    }

    @Override
    public void onPageSelected(int position)
    {
        //ViewPager 滑動之後觸發
        tabLayout.getTabAt(position).select();
    }

    @Override
    public void onPageScrollStateChanged(int state)
    {

    }
}