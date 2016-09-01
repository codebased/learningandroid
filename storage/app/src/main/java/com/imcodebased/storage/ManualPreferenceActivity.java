package com.imcodebased.storage;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.preference.PreferenceManager;
import android.util.Log;
import android.view.View;

/**
 * Created by codebased on 24/08/16.
 */
public class ManualPreferenceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manual_preference);
    }

    public void saveme(View view) {

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        sharedPreferences.edit().putString("SAVE", "ME").commit();

        Log.i("Manual", sharedPreferences.getString("SAVE", "NOT"));
    }
}
