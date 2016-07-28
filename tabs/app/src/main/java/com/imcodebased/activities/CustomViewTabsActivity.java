package com.imcodebased.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.imcodebased.fragments.FragmentOne;
import com.imcodebased.fragments.FragmentThree;
import com.imcodebased.fragments.FragmentTwo;
import com.imcodebased.adapters.CustomTabsAdapter;

import java.util.ArrayList;
import java.util.List;

public class CustomViewTabsActivity extends AppCompatActivity {

	private List<Fragment> fragmentList = new ArrayList<>();
	private List<String> titleList = new ArrayList<>();

	private ViewPager viewPager;
	private CustomTabsAdapter adapter;
	private TabLayout tabLayout;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_custom_tabs);

		initialise();

		prepareDataResource();

		adapter = new CustomTabsAdapter(getSupportFragmentManager(), fragmentList, titleList);

		// Bind Adapter to ViewPager.
		viewPager.setAdapter(adapter);

		// Link ViewPager and TabLayout
		tabLayout.setupWithViewPager(viewPager);

		// Setting up Custom Tab View
		setCustomViewForTabs();
	}

	// Initialise Activity Data
	private void initialise() {
		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		toolbar.setTitle("Custom View Tabs");

		viewPager = (ViewPager) findViewById(R.id.viewPager);
		tabLayout = (TabLayout) findViewById(R.id.tabs);
	}

	// Let's prepare Data for our Tabs - Fragments and Title List
	private void prepareDataResource() {

		addData(new FragmentOne(), "ONE");
		addData(new FragmentTwo(), "TWO");
		addData(new FragmentThree(), "THREE");
	}

	private void addData(Fragment fragment, String title) {
		fragmentList.add(fragment);
		titleList.add(title);
	}

	// Sets the Custom View for Tabs
	private void setCustomViewForTabs() {
		setCustomViewForTab(0, "WALL", "TAB ONE");
		setCustomViewForTab(1, "CHAT", "TAB TWO");
		setCustomViewForTab(2, "PROFILE", "TAB THREE");
	}

	private void setCustomViewForTab(int position, String title, String subtitle) {

		LinearLayout tabView = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.tab_item, null);

		TextView txvTitle = (TextView) tabView.findViewById(R.id.tabTextTitle);
		txvTitle.setText(title);

		TextView txvSubTitle = (TextView) tabView.findViewById(R.id.tabTextSubTitle);
		txvSubTitle.setText(subtitle);

		tabLayout.getTabAt(position).setCustomView(tabView);
	}
}
