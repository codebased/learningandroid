package com.imcodebased.animations.viewanimations;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

import com.imcodebased.animations.R;

public class TweenAnimationMainActivity extends AppCompatActivity implements Animation.AnimationListener {

    private static final String TAG = "TweekAnimation";
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tween_animation);
        imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(TweenAnimationMainActivity.this, "Clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        // open will be used for the coming activity
        // close will be used for this activity
        overridePendingTransition(R.anim.activity_open_scale,R.anim.activity_close_translate);
    }

    public void rotateAnimation(View view) {

        Animation animation = AnimationUtils.loadAnimation(getBaseContext(), R.anim.rotation);
        animation.setAnimationListener(this);
        imageView.startAnimation(animation);

    }

    public void setAnimation(View view) {
        Animation animation = AnimationUtils.loadAnimation(getBaseContext(), R.anim.animationset);
        animation.setAnimationListener(this);
        imageView.startAnimation(animation);
    }

    public void scaleAnimation(View view) {
        Animation animation = AnimationUtils.loadAnimation(getBaseContext(), R.anim.scale);
        animation.setAnimationListener(this);
        imageView.startAnimation(animation);
    }

    public void alphaAnimation(View view) {
        Animation animation = AnimationUtils.loadAnimation(getBaseContext(), R.anim.alpha);
        animation.setAnimationListener(this);
        imageView.startAnimation(animation);
    }

    public void translateAnimation(View view) {
        Animation animation = AnimationUtils.loadAnimation(getBaseContext(), R.anim.translate);
        animation.setAnimationListener(this);
        imageView.startAnimation(animation);
    }

    @Override
    public void onAnimationStart(Animation animation) {

        Log.i(TAG, "Animation Started");
    }

    @Override
    public void onAnimationEnd(Animation animation) {

        Log.i(TAG, "Animation End");

    }

    @Override
    public void onAnimationRepeat(Animation animation) {
        Log.i(TAG, "Animation Repeat");

    }

    public void setSpiralAnimation(View view) {

        Animation animation = AnimationUtils.loadAnimation(getBaseContext(), R.anim.transitrotate);
        animation.setAnimationListener(this);
        imageView.startAnimation(animation);
    }
}
