package com.imcodebased.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.imcodebased.fragments.FragmentFive;
import com.imcodebased.fragments.FragmentFour;
import com.imcodebased.fragments.FragmentOne;
import com.imcodebased.fragments.FragmentSix;
import com.imcodebased.fragments.FragmentThree;
import com.imcodebased.fragments.FragmentTwo;
import com.imcodebased.adapters.ScrollTabsAdapter;

import java.util.ArrayList;
import java.util.List;

public class ScrollTabsActivity extends AppCompatActivity {

    private List<Fragment> fragmentList = new ArrayList<>();
    private List<String> titleList = new ArrayList<>();

    private ViewPager viewPager;
    private ScrollTabsAdapter adapter;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_tabs);

        initialise();

        prepareDataResource();

        adapter = new ScrollTabsAdapter(getSupportFragmentManager(), fragmentList, titleList);

        viewPager.setAdapter(adapter);

        tabLayout.setupWithViewPager(viewPager);
    }

    private void initialise() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Scrollable Tabs");

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
    }

    private void prepareDataResource() {

        addData(new FragmentOne(), "ONE");
        addData(new FragmentTwo(), "TWO");
        addData(new FragmentThree(), "THREE");
        addData(new FragmentFour(), "FOUR");
        addData(new FragmentFive(), "FIVE");
        addData(new FragmentSix(), "SIX");

        addData(new FragmentOne(), "ONE");
        addData(new FragmentTwo(), "TWO");
        addData(new FragmentThree(), "THREE");
        addData(new FragmentFour(), "FOUR");
        addData(new FragmentFive(), "FIVE");
        addData(new FragmentSix(), "SIX");
    }

    private void addData(Fragment fragment, String title) {
        fragmentList.add(fragment);
        titleList.add(title);
    }
}
