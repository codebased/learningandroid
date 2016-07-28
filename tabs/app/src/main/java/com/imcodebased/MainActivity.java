package com.imcodebased;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.imcodebased.activities.CustomViewTabsActivity;
import com.imcodebased.activities.IconTabsActivity;
import com.imcodebased.activities.R;
import com.imcodebased.activities.ScrollTabsActivity;
import com.imcodebased.activities.TextTabsActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Papu Tabs Shop");
        setSupportActionBar(toolbar);

        findViewById(R.id.textTabsView).setOnClickListener(this);
        findViewById(R.id.scrollableTabsView).setOnClickListener(this);
        findViewById(R.id.iconTabsView).setOnClickListener(this);
        findViewById(R.id.customTabsView).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        Intent intent = null;

        switch (view.getId()) {

            case R.id.textTabsView:
                intent = new Intent(MainActivity.this, TextTabsActivity.class);
                break;

            case R.id.iconTabsView:
                intent = new Intent(MainActivity.this, IconTabsActivity.class);
                break;

            case R.id.scrollableTabsView:
                intent = new Intent(MainActivity.this, ScrollTabsActivity.class);
                break;

            case R.id.customTabsView:
                intent = new Intent(MainActivity.this, CustomViewTabsActivity.class);
                break;
        }

        startActivity(intent);
    }
}
