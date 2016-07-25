package com.imcodebased.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import static helpers.LogUtil.logSuperStartEntry;
import static helpers.LogUtil.logSuperStopEntry;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    protected void onCreate(Bundle savedInstanceState) {

        logSuperStartEntry(MainActivity.class);
        super.onCreate(savedInstanceState);
        logSuperStopEntry(MainActivity.class);
        setContentView(R.layout.activity_main);

        findViewById(R.id.launchXmlFragmentActivity).setOnClickListener(this);
        findViewById(R.id.launchDynamicFragmentActivity).setOnClickListener(this);
    }


    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        logSuperStartEntry(MainActivity.class);
        super.onPostCreate(savedInstanceState);
        logSuperStopEntry(MainActivity.class);
    }

    @Override
    protected void onStart() {
        logSuperStartEntry(MainActivity.class);
        super.onStart();
        logSuperStopEntry(MainActivity.class);
    }

    @Override
    protected void onResume() {
        logSuperStartEntry(MainActivity.class);
        super.onResume();
        logSuperStopEntry(MainActivity.class);
    }

    @Override
    protected void onStop() {
        logSuperStartEntry(MainActivity.class);
        super.onStop();
        logSuperStopEntry(MainActivity.class);
    }

    @Override
    protected void onPause() {
        logSuperStartEntry(MainActivity.class);
        super.onPause();
        logSuperStopEntry(MainActivity.class);
    }

    @Override
    protected void onDestroy() {
        logSuperStartEntry(MainActivity.class);
        super.onDestroy();
        logSuperStopEntry(MainActivity.class);
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
