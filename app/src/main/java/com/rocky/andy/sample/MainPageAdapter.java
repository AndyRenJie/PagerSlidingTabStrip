package com.rocky.andy.sample;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.rocky.andy.library.RJPagerSlidingTabStrip;

import java.util.List;

/**
 * Created by Andy.Ren on 2018/5/17.
 */

public class MainPageAdapter extends FragmentStatePagerAdapter implements RJPagerSlidingTabStrip.ImageTabListener{

    private List<Fragment> fragmentList;
    private String [] titles;

    public MainPageAdapter(FragmentManager fm,List<Fragment>fragmentList, String[]titles){
        super(fm);
        this.fragmentList = fragmentList;
        this.titles = titles;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }

    @Override
    public int getPageImageResId() {
        return R.mipmap.ic_launcher;
    }
}
