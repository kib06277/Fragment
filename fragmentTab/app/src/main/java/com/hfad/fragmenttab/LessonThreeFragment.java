package com.hfad.fragmenttab;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class LessonThreeFragment extends Fragment
{
    //顯示文字內容
    private String text = "";

    @Override
    public void onAttach(Activity activity)
    {
        super.onAttach(activity);

        //取得MainActivity的方法，將文字放入text字串
        MainActivity mMainActivity = (MainActivity) activity;
        text = mMainActivity.getLessonThreeText();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        //導入Tab分頁的Fragment Layout
        return inflater.inflate(R.layout.fragment_layout, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);

        //取得TextView元件並帶入text字串
        TextView mText = (TextView) getView().findViewById(R.id.text);
        mText.setText(text);

        //取得ImageView元件並帶入指定圖片
        ImageView mImg = (ImageView) getActivity().findViewById(R.id.img);
        mImg.setImageResource(R.drawable.lesson3_item);
    }
}
