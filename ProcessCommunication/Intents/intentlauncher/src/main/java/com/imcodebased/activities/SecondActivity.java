package com.imcodebased.activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.imcodebased.customintentlauncher.R;

/**
 * Created by codebased on 24/07/16.
 */
public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText resultEditView;
    private Button launchFirstActivityView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_second);
        resultEditView = (EditText) findViewById(R.id.result);
        launchFirstActivityView = (Button) findViewById(R.id.launchFirstActivity);

        resultEditView.setText(getIntent().getCharSequenceExtra("args"));

        launchFirstActivityView.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.launchFirstActivity:
                getIntent().putExtra("result", resultEditView.getText());
                setResult(Activity.RESULT_OK, getIntent());
                // by using onback pressed it will do exactly the same thing as finish.
                // because it will eventually call finish().
//                onBackPressed();
                finish();
        }
    }
}
