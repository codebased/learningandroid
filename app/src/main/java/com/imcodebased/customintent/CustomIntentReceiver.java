package com.imcodebased.customintent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class CustomIntentReceiver extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_intent_receiver);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        setIntent(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        processIntent();
    }

    private void processIntent(){
        Intent curIntent = getIntent();

        if ( curIntent == null ) return;

        Toast.makeText(CustomIntentReceiver.this, curIntent.getScheme(), Toast.LENGTH_SHORT).show();
    }
}
