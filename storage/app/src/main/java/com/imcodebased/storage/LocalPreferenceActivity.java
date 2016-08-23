package com.imcodebased.storage;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by codebased on 23/08/16.
 */
public class LocalPreferenceActivity extends AppCompatActivity {

    private static final String DEFAULT_STRING = "DEFAULT_STRING";
    private TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        textView = new TextView(this);
        setContentView(textView);
        textView.setText(getPreferences(MODE_PRIVATE).getString(DEFAULT_STRING, "DEFAULT"));

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        textView.setText(getPreferences(MODE_PRIVATE).getString(DEFAULT_STRING, "onRestoreInstanceState"));

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        getPreferences(MODE_PRIVATE).edit().putString(DEFAULT_STRING, "onSaveInstanceState").commit();

    }
}
