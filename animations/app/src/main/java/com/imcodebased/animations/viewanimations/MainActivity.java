package com.imcodebased.animations.viewanimations;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.imcodebased.animations.R;

/**
 * Created by codebased on 1/09/16.
 */
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void tweenActivity(View view) {
        startActivity(new Intent(this, TweenAnimationMainActivity.class));
        // open will be used for the coming activity
        // close will be used for this activity
        overridePendingTransition(R.anim.activity_open_translate,R.anim.activity_close_scale);
    }

    public void frameActivity(View view) {
        startActivity(new Intent(this, FrameAnimationMainActivity.class));
        overridePendingTransition(R.anim.activity_push_up_in, R.anim.activity_push_up_out);

    }

    public void viewFlipperActivity(View view) {
        startActivity(new Intent(this, ViewAnimatorActivity.class));
        overridePendingTransition(R.anim.activity_open_scale,R.anim.activity_close_translate);
    }

    public void propertyActivity(View view) {
        startActivity(new Intent(this, PropertyAnimationMainActivity.class));

    }

    public void fragmentActivity(View view) {
        startActivity(new Intent(this, FragmentAnimationActivity.class));
    }
}
