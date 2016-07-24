package com.imcodebased.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.imcodebased.customintentlauncher.R;

/**
 * Created by codebased on 24/07/16.
 */
public class FirstActivity extends AppCompatActivity implements View.OnClickListener {

    public static final int REQUEST_CODE = 2000;

    private Button launchSecondActivityWithResultView;
    private EditText argsEditTextView;
    private TextView resultTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        argsEditTextView = (EditText) findViewById(R.id.argument);
        resultTextView = (TextView) findViewById(R.id.result);
        launchSecondActivityWithResultView = (Button) findViewById(R.id.launchSecondActivityWithResult);
        launchSecondActivityWithResultView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.launchSecondActivityWithResult:
                Intent secondIntent = new Intent(this, SecondActivity.class);
                secondIntent.putExtra("args", argsEditTextView.getText());
                startActivityForResult(secondIntent, FirstActivity.REQUEST_CODE);
                break;

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == REQUEST_CODE) {
            resultTextView.setText(data.getCharSequenceExtra("result"));
        } else {
            resultTextView.setText("");
        }
    }
}
