package com.imcodebased.androidviewlifecycle;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import static com.imcodebased.androidviewlifecycle.LogUtil.logSuperStartEntry;
import static com.imcodebased.androidviewlifecycle.LogUtil.logSuperStopEntry;

public class MainActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        logSuperStartEntry(MainActivity.class);
        super.onCreate(savedInstanceState);
        logSuperStopEntry(MainActivity.class);

        setContentView(R.layout.activity_main);
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
}
