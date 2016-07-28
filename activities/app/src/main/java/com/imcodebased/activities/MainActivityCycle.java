package com.imcodebased.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import static helpers.LogUtil.logSuperStartEntry;
import static helpers.LogUtil.logSuperStopEntry;

public class MainActivityCycle extends AppCompatActivity implements View.OnClickListener {

    protected void onCreate(Bundle savedInstanceState) {

        logSuperStartEntry(MainActivityCycle.class);
        super.onCreate(savedInstanceState);
        logSuperStopEntry(MainActivityCycle.class);
        setContentView(R.layout.activity_main);

        findViewById(R.id.launchXmlFragmentActivity).setOnClickListener(this);
        findViewById(R.id.launchDynamicFragmentActivity).setOnClickListener(this);
    }


    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        logSuperStartEntry(MainActivityCycle.class);
        super.onPostCreate(savedInstanceState);
        logSuperStopEntry(MainActivityCycle.class);
    }

    @Override
    protected void onStart() {
        logSuperStartEntry(MainActivityCycle.class);
        super.onStart();
        logSuperStopEntry(MainActivityCycle.class);
    }

    @Override
    protected void onResume() {
        logSuperStartEntry(MainActivityCycle.class);
        super.onResume();
        logSuperStopEntry(MainActivityCycle.class);
    }

    @Override
    protected void onStop() {
        logSuperStartEntry(MainActivityCycle.class);
        super.onStop();
        logSuperStopEntry(MainActivityCycle.class);
    }

    @Override
    protected void onPause() {
        logSuperStartEntry(MainActivityCycle.class);
        super.onPause();
        logSuperStopEntry(MainActivityCycle.class);
    }

    @Override
    protected void onDestroy() {
        logSuperStartEntry(MainActivityCycle.class);
        super.onDestroy();
        logSuperStopEntry(MainActivityCycle.class);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.launchXmlFragmentActivity) {
            startActivity(new Intent(this, XmlFragmentActivity.class));
        } else if (view.getId() == R.id.launchDynamicFragmentActivity) {
            startActivity(new Intent(this, DynamicFragmentActivity.class));
        }
    }
}
