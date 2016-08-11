package com.imcodebased.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by codebased on 11/08/16.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.saveStateActivity:
                startActivity(new Intent(this, SaveStateActivity.class));
                break;
            case R.id.relativeLayoutActivity:
                startActivity(new Intent(this, RelativeLayoutActivity.class));
                break;
            case R.id.linearLayoutActivity:
                startActivity(new Intent(this, LinearLayoutActivity.class));
                break;
            case R.id.frameLayoutActivity:
                startActivity(new Intent(this, FrameLayoutActivity.class));
                break;
            case R.id.menuActivity:
                startActivity(new Intent(this, DynamicViewWithMenuActivity.class));
                break;
            case R.id.parcelableActivity:
                startActivity(new Intent(this, ParcelableActivity.class));
                break;
            case R.id.gravityActivity:
                startActivity(new Intent(this, GravityActivity.class));
                break;

        }
    }
}
