package com.imcodebased.storage;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class UserPreferenceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.content, new UserPreferenceFragment())
                .commit();

    }
}
