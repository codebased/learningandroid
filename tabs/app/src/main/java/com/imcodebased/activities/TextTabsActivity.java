package com.imcodebased.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.imcodebased.adapters.TextTabsAdapter;
import com.imcodebased.fragments.FragmentFive;
import com.imcodebased.fragments.FragmentFour;
import com.imcodebased.fragments.FragmentOne;
import com.imcodebased.fragments.FragmentThree;
import com.imcodebased.fragments.FragmentTwo;

import java.util.ArrayList;
import java.util.List;

public class TextTabsActivity extends AppCompatActivity {

    protected List<Fragment> fragmentList = new ArrayList<>();
    protected List<String> titleList = new ArrayList<>();

    protected ViewPager viewPager;
    protected TextTabsAdapter adapter;
    protected TabLayout tabLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_tabs);

        initialise();

        prepareDataResource();

        adapter = new TextTabsAdapter(getSupportFragmentManager(), fragmentList, titleList);

        // Bind Adapter to ViewPager.
        viewPager.setAdapter(adapter);

        // Link ViewPager and TabLayout
        tabLayout.setupWithViewPager(viewPager);
    }

    // Initialise Activity Data.
    private void initialise() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Text Tabs");

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
    }

    private void prepareDataResource() {

        addData(new FragmentOne(), "ONE");
        addData(new FragmentTwo(), "TWO");
        addData(new FragmentThree(), "THREE");
        addData(new FragmentFour(), "FOUR");
        addData(new FragmentFive(), "FIVE");
    }

    private void addData(Fragment fragment, String title) {
        fragmentList.add(fragment);
        titleList.add(title);
    }
}
