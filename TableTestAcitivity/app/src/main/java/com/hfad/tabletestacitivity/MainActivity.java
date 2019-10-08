package com.hfad.tabletestacitivity;

import android.app.TabActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.TabHost;

public class MainActivity extends TabActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        //獲得當前 TabActivity 的 TabHost
        TabHost tabHost = getTabHost();

        LayoutInflater.from(this).inflate(R.layout.activity_main,tabHost.getTabContentView(),true);
        tabHost.addTab(tabHost.newTabSpec("tab1").setIndicator("主頁").setContent(R.id.view1));
        tabHost.addTab(tabHost.newTabSpec("tab2").setIndicator("標題").setContent(R.id.view2));
        tabHost.addTab(tabHost.newTabSpec("tab3").setIndicator("簡介").setContent(R.id.view3));
        tabHost.addTab(tabHost.newTabSpec("tab4").setIndicator("關於").setContent(R.id.view4));
    }
}
