package com.example.rd_softwaredeveloper.fragment_demo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DetailsFragment extends Fragment
{
    private View v;
    public static DetailsFragment newInstance(int index)
    {
        DetailsFragment f = new DetailsFragment();

        // Supply index input as an argument.
        Bundle args = new Bundle();
        args.putInt("index", index);
        f.setArguments(args);
        return f;
    }

    public int getShownIndex()
    {
        return getArguments().getInt("index", 0);
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        v = inflater.inflate(R.layout.fragment_details, container, false);
        TextView text = (TextView)v.findViewById(R.id.text_view);
        text.setText("Page" + getShownIndex());
        return v;
    }
}
