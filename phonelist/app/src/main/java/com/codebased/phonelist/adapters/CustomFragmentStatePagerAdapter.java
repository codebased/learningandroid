package com.codebased.phonelist.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.codebased.phonelist.fragments.MobilePaymentFragment;
import com.codebased.phonelist.fragments.AddressBookPaymentFragment;

import java.util.ArrayList;
import java.util.List;

public class CustomFragmentStatePagerAdapter extends FragmentStatePagerAdapter {

    List<String> titles;
    List<Fragment> fragments;

    public CustomFragmentStatePagerAdapter(FragmentManager fm) {
        super(fm);
        fragments = new ArrayList<>();
        titles = new ArrayList<>();
        fragments.add(new MobilePaymentFragment());
        fragments.add(new AddressBookPaymentFragment());
        fragments.add(new Fragment());

        titles.add("Pay to Mobile Phone");
        titles.add("Pay to Account");
        titles.add("International Money Transfer");
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }
}
