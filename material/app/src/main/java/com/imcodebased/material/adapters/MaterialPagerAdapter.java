package com.imcodebased.material.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.imcodebased.material.fragments.ContactFragment;
import com.imcodebased.material.fragments.ListFragment;
import com.imcodebased.material.fragments.SettingsFragment;

/**
 * Created by codebased on 8/09/16.
 */
public class MaterialPagerAdapter extends FragmentPagerAdapter {

    public MaterialPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new ListFragment();
            case 1:
                return new ContactFragment();
            case 2:
                return new SettingsFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "LIST";
            case 1:
                return "CONTACT";
            case 2:
                return "SETTINGS";
            default:
                return null;
        }
    }
}
