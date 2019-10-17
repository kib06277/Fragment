package com.hfad.dialogbottomnavigationviewpagerfragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.hfad.dialogbottomnavigationviewpagerfragment.ui.dashboard.DashboardFragment;
import com.hfad.dialogbottomnavigationviewpagerfragment.ui.home.HomeFragment;
import com.hfad.dialogbottomnavigationviewpagerfragment.ui.notifications.NotificationsFragment;

public class DialogViewTest extends DialogFragment implements ViewPager.OnPageChangeListener
{
    private BottomNavigationView navigation;
    private ViewPager viewPager;

    private DashboardFragment fragment1 = new DashboardFragment();
    private HomeFragment fragment2 = new HomeFragment();
    private NotificationsFragment fragment3 = new NotificationsFragment();

    public DialogViewTest(MainActivity mainActivity)
    {
        super();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.dialog, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        viewPager = (ViewPager) view.findViewById(R.id.viewPager);

        //添加 viewPager 事件
        viewPager.addOnPageChangeListener(this);
        navigation = (BottomNavigationView) view.findViewById(R.id.nav_view);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        viewPager.setAdapter(new FragmentPagerAdapter(getChildFragmentManager())
        {
            @Override
            public Fragment getItem(int position)
            {
                switch (position)
                {
                    case 0:
                        return fragment2;
                    case 1:
                        return fragment1;
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
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels)
    {

    }

    @Override
    public void onPageSelected(int position)
    {
        //頁面滑動時，改變 BottomNavigationView 的 Item 高度
        navigation.getMenu().getItem(position).setChecked(true);
    }

    @Override
    public void onPageScrollStateChanged(int state)
    {

    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener()
    {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item)
        {
            //點擊 BottomNavigationView 的 Item 項目，切換 ViewPage 頁面
            //menu/navigation.xml 裡面加的 android:orderInCategory 屬性就是 Item.getOrder() 的值
            viewPager.setCurrentItem(item.getOrder());
            return true;
        }
    };

}
