package com.imcodebased.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

public class DynamicFragmentActivity extends FragmentActivity implements View.OnClickListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_fragment);
        findViewById(R.id.launchFragment1).setOnClickListener(this);
        findViewById(R.id.launchFragment2).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.launchFragment1:
                loadFragment("fragment1", new Fragment1());
                getSupportFragmentManager().executePendingTransactions();

                break;
            case R.id.launchFragment2:
                loadFragment("fragment2", new Fragment2());
                getSupportFragmentManager().executePendingTransactions();

                break;
        }
    }


    private void loadFragment(String fragmentTag, Fragment fragment) {
        getSupportFragmentManager().beginTransaction().add(R.id.container, fragment, fragmentTag).addToBackStack(fragmentTag).commit();
    }
}
