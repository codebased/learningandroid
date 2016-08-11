package com.imcodebased.views;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by codebased on 11/08/16.
 */

// major difference between Parcelable and Serializable is latter uses reflection, which is slow
// read here: http://www.developerphil.com/parcelable-vs-serializable/
public class ParcelableActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parcelable);
        Bundle bundle = new Bundle();
        bundle.putParcelable("object", new Quote());

        Quote quote = bundle.getParcelable("object");
        TextView textView = (TextView) findViewById(R.id.textBoxView);
        textView.setText(quote.getQuote());
    }
}
