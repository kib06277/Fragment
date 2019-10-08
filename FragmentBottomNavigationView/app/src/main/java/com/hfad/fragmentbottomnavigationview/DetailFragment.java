package com.hfad.fragmentbottomnavigationview;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import static com.hfad.fragmentbottomnavigationview.MainActivity.DETAIL_MESSAGE;

public class DetailFragment extends Fragment
{
    private TextView mTextTitle;
    public DetailFragment()
    {
        // Requires empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState)
    {
        View root = inflater.inflate(R.layout.fragment_detail, container, false);
        mTextTitle = (TextView) root.findViewById(R.id.text_title_detail);
        return root;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        if (getArguments() != null)
        {
            mTextTitle.setText(getArguments().getString(DETAIL_MESSAGE));
        }
    }
}
