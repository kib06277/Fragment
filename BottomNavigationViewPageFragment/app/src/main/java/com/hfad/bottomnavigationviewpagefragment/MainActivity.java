package com.hfad.bottomnavigationviewpagefragment;

import android.os.Bundle;
import android.view.MenuItem;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.hfad.bottomnavigationviewpagefragment.ui.dashboard.DashboardFragment;
import com.hfad.bottomnavigationviewpagefragment.ui.home.HomeFragment;
import com.hfad.bottomnavigationviewpagefragment.ui.notifications.NotificationsFragment;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener
{
    private BottomNavigationView navigation;
    private ViewPager viewPager;

    private DashboardFragment fragment1 = new DashboardFragment();
    private HomeFragment fragment2 = new HomeFragment();
    private NotificationsFragment fragment3 = new NotificationsFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        //添加 viewPager 事件
        viewPager.addOnPageChangeListener(this);
        navigation = (BottomNavigationView) findViewById(R.id.nav_view);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager())
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
