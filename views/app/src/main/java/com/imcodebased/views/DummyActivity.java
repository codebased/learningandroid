package com.imcodebased.views;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * Created by codebased on 8/08/16.
 */
public class DummyActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "DummyActivity";
    private Button btn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dummy);
        btn = (Button) findViewById(R.id.goback);
        btn.setOnClickListener(this);
    }

    @Override
    public void onBackPressed() {
        Log.d(TAG, "onBackPressed");
        super.onBackPressed();
    }

    @Override
    protected void onPause() {
        Log.d(TAG, "onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

    @Override
    public void onClick(View v) {
        // finish will not save the state.
        finish();
        // it will call an event called onBackPressed where as in case of finish() it is not going to make a call.
        onBackPressed();
    }
}
