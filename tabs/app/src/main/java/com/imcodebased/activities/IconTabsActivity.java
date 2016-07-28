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
import com.imcodebased.adapters.IconTabsAdapter;

import java.util.ArrayList;
import java.util.List;

public class IconTabsActivity extends AppCompatActivity {

    private List<Fragment> fragmentList = new ArrayList<>();

    private ViewPager viewPager;
    private IconTabsAdapter adapter;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_icon_tabs);

        initialise();

        prepareDataResource();

        adapter = new IconTabsAdapter(getSupportFragmentManager(), fragmentList);

        viewPager.setAdapter(adapter);

        tabLayout.setupWithViewPager(viewPager);

        setTabIcons();
    }

    // Initialise Activity Data
    private void initialise() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Icon Tabs");

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
    }

    private void prepareDataResource() {

        fragmentList.add(new FragmentOne());
        fragmentList.add(new FragmentTwo());
        fragmentList.add(new FragmentThree());
        fragmentList.add(new FragmentFour());
        fragmentList.add(new FragmentFive());
        fragmentList.add(new FragmentSix());
    }

    private void setTabIcons() {

        tabLayout.getTabAt(0).setIcon(R.drawable.facebook);
        tabLayout.getTabAt(1).setIcon(R.drawable.linkedin);
        tabLayout.getTabAt(2).setIcon(R.drawable.whatsapp);
        tabLayout.getTabAt(3).setIcon(R.drawable.youtube);
        tabLayout.getTabAt(4).setIcon(R.drawable.twitter);
        tabLayout.getTabAt(5).setIcon(R.drawable.googleplus);
    }
}

