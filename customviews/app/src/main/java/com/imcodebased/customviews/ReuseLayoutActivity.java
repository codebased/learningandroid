package com.imcodebased.customviews;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewStub;

/**
 * Created by codebased on 17/08/16.
 */
public class ReuseLayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reuse_layout);
    }

    public void expend(View view) {

        ViewStub stub = (ViewStub) findViewById(R.id.stub);
        View inflated = stub.inflate();
    }
}
