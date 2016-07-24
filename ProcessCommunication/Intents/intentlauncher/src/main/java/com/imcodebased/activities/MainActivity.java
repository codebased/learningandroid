package com.imcodebased.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.imcodebased.customintentlauncher.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button launchIntentButtonView;
    private Button launchSendIntentButtonView;
    private Button launchFirstActivityView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        launchIntentButtonView = (Button) findViewById(R.id.launchIntentButtonView);
        launchSendIntentButtonView = (Button) findViewById(R.id.launchSendIntentButtonView);
        launchFirstActivityView = (Button) findViewById(R.id.launchFirstActivity);

        launchIntentButtonView.setOnClickListener(this);
        launchSendIntentButtonView.setOnClickListener(this);
        launchFirstActivityView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.launchIntentButtonView:
                launchCustomIntent();
                break;
            case R.id.launchFirstActivity:
                // you can either call by action name or class name (if it is in same apk);
                startActivity(new Intent("com.imcodebased.activities.FirstActivity"));
                break;
            default:
                startActivity(IntentUtil.createShareIntent("Yo"));
                break;
        }
    }

    private void launchCustomIntent() {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("curry");
        builder.authority("www.imcodebased.com");
        builder.path("/");

        Intent intent = new Intent("MYACTION", builder.build());
        intent.addCategory(Intent.CATEGORY_DEFAULT);
        intent.addCategory("com.imcodebased.intent.category.TOAST");
        Intent which = Intent.createChooser(intent, "Choose");

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(which);
        }
    }
}
