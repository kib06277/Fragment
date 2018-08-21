package com.example.rd_softwaredeveloper.fragment_demo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
{
    private Button backBtn,nextBtn;
    private int page = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        backBtn = (Button)findViewById(R.id.back_button);
        nextBtn = (Button)findViewById(R.id.next_button);
        changeFragment(DetailsFragment.newInstance(page));
        backBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(page>1)
                {
                    changeFragment(DetailsFragment.newInstance(--page));
                }
                else
                {
                    changeFragment(DetailsFragment.newInstance(page));
                }
            }

        });

        nextBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                changeFragment(DetailsFragment.newInstance(++page));
            }
        });
    }

    private void changeFragment(Fragment f)
    {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, f);
        transaction.commitAllowingStateLoss();
    }
}
