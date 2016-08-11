package com.imcodebased.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SaveStateActivity extends AppCompatActivity {

    private TextView textBoxView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_state);

        textBoxView = (TextView) findViewById(R.id.textBoxView);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        String savedValue = savedInstanceState.getString("save");
        textBoxView.setText(savedValue);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString("save", textBoxView.getText().toString());

    }
}
