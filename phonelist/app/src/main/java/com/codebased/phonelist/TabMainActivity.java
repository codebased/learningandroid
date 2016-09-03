package com.codebased.phonelist;

import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.codebased.phonelist.adapters.CustomFragmentStatePagerAdapter;

public class TabMainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ViewPager viewpager;
    private TabLayout tablayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tablayout = (TabLayout) findViewById(R.id.tablayout);
        viewpager = (ViewPager) findViewById(R.id.viewpager);

        toolbar.setTitle("Wonderland App");
        viewpager.setAdapter(new CustomFragmentStatePagerAdapter(getSupportFragmentManager()));
        tablayout.setupWithViewPager(viewpager);
    }


}
