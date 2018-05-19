package com.rocky.andy.sample;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import com.rocky.andy.library.RJPagerSlidingTabStrip;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private RJPagerSlidingTabStrip tabStrip;
    private List <Fragment> fragmentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.view_pager);
        tabStrip = findViewById(R.id.tab_title);

        String [] titles = getResources().getStringArray(R.array.str_titles);
        fragmentList = new ArrayList<>();
        for (int i = 0; i < titles.length; i++) {
            Bundle bundle = new Bundle();
            bundle.putString("title",titles[i]);
            ContentFragment contentFragment = new ContentFragment();
            contentFragment.setArguments(bundle);
            fragmentList.add(contentFragment);
        }
        viewPager.setAdapter(new MainPageAdapter(getSupportFragmentManager(),fragmentList,titles));
        tabStrip.setViewPager(viewPager);
    }
}
