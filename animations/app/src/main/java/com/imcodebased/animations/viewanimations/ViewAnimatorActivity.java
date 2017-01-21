package com.imcodebased.animations.viewanimations;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ViewAnimator;

import com.imcodebased.animations.R;

/**
 * Created by codebased on 1/09/16.
 */
public class ViewAnimatorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewmaster);
        final ViewAnimator pages =
                (ViewAnimator) findViewById(R.id.pages);
        Button prev = (Button) findViewById(R.id.prev);
        Button next = (Button) findViewById(R.id.next);
        prev.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                pages.showPrevious();
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                pages.showNext();
            }
        });
    }
}
