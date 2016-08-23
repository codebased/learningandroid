package com.imcodebased.storage;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by codebased on 23/08/16.
 */
public class MainActivity extends AppCompatActivity {

    private Button btn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btnInternalStorageActivity:
                startActivity(new Intent(this, InternalStorageActivity.class));
                break;
            case R.id.btnLocalpreferenceActivity:
                startActivity(new Intent(this, LocalPreferenceActivity.class));
                break;
            case R.id.btnPreferenceActivity:
                startActivity(new Intent(this, UserPreferenceActivity.class));
                break;
            case R.id.btnManualActivity:
                startActivity(new Intent(this, ManualPreferenceActivity.class));
                break;
        }
    }
}
