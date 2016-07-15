package com.imcodebased.customintentlauncher;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button launchIntentButtonView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        launchIntentButtonView = (Button) findViewById(R.id.launchIntentButtonView);
        launchIntentButtonView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Uri.Builder builder = new Uri.Builder();
                builder.scheme("curry");
                builder.authority("www.imcodebased.com");
                builder.path("/");

                Intent intent = new Intent("MYACTION", builder.build());
                intent.addCategory(Intent.CATEGORY_DEFAULT);
                intent.addCategory("com.imcodebased.intent.category.TOAST");
                Intent which = Intent.createChooser(intent, "Choose");

                startActivity(which);

            }
        });
    }
}
