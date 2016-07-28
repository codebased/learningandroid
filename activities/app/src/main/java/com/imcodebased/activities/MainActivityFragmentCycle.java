package com.imcodebased.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import static helpers.LogUtil.logSuperStartEntry;
import static helpers.LogUtil.logSuperStopEntry;

public class MainActivityFragmentCycle extends AppCompatActivity implements View.OnClickListener {

    protected void onCreate(Bundle savedInstanceState) {

        logSuperStartEntry(MainActivityFragmentCycle.class);
        super.onCreate(savedInstanceState);
        logSuperStopEntry(MainActivityFragmentCycle.class);
        setContentView(R.layout.activity_fragment_main);
        getSupportFragmentManager().beginTransaction().add(R.id.container, new Fragment1(), "").commit();
    }


    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        logSuperStartEntry(MainActivityFragmentCycle.class);
        super.onPostCreate(savedInstanceState);
        logSuperStopEntry(MainActivityFragmentCycle.class);
    }

    @Override
    protected void onStart() {
        logSuperStartEntry(MainActivityFragmentCycle.class);
        super.onStart();
        logSuperStopEntry(MainActivityFragmentCycle.class);
    }

    @Override
    protected void onResume() {
        logSuperStartEntry(MainActivityFragmentCycle.class);
        super.onResume();
        logSuperStopEntry(MainActivityFragmentCycle.class);
    }

    @Override
    protected void onStop() {
        logSuperStartEntry(MainActivityFragmentCycle.class);
        super.onStop();
        logSuperStopEntry(MainActivityFragmentCycle.class);
    }

    @Override
    protected void onPause() {
        logSuperStartEntry(MainActivityFragmentCycle.class);
        super.onPause();
        logSuperStopEntry(MainActivityFragmentCycle.class);
    }

    @Override
    protected void onDestroy() {
        logSuperStartEntry(MainActivityFragmentCycle.class);
        super.onDestroy();
        logSuperStopEntry(MainActivityFragmentCycle.class);
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
