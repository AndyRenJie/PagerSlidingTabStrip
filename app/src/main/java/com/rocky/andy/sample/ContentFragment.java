package com.rocky.andy.sample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Andy.Ren on 2018/5/19.
 */

public class ContentFragment extends Fragment{

    private View mRootView;
    private TextView titleTV;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(mRootView == null){
            mRootView = inflater.inflate(R.layout.fragment_content_layout,container,false);
            initView(mRootView);
        }
        return mRootView;
    }

    private void initView(View mRootView) {
        titleTV = mRootView.findViewById(R.id.tv_title);
        titleTV.setText(getArguments().getString("title"));
    }
}
