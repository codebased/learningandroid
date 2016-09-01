package com.imcodebased.animations.viewanimations;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AccelerateInterpolator;

import com.imcodebased.animations.R;

/**
 * Created by codebased on 1/09/16.
 */
public class PropertyAnimationMainActivity extends AppCompatActivity {
    ValueAnimator valueAnimator;
    ObjectAnimator objectAnimator;
    private View ballView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_animation_main);
        ballView = findViewById(R.id.ballView);
        valueAnimator = ValueAnimator.ofInt(0, 400);
        objectAnimator =
                ObjectAnimator.ofFloat(
                        ballView,
                        "TranslationX",
                        0,
                        400
                );
    }

    public void objectAnimation(View view) {

        valueAnimator.end();

        objectAnimator.end();


        objectAnimator.setDuration(2000);
        objectAnimator.setRepeatMode(ObjectAnimator.REVERSE);
        objectAnimator.setRepeatCount(ObjectAnimator.INFINITE);

        objectAnimator.start();
    }

    public void valueAnimation(View view) {
        valueAnimator.end();

        objectAnimator.end();
        valueAnimator.setFrameDelay(50);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                final int animatedValue =
                        (Integer) valueAnimator.getAnimatedValue();
                ballView.post(new Runnable() {
                    public void run() {
                        ballView.setPadding(
                                ballView.getPaddingLeft(),
                                400 - animatedValue,
                                ballView.getPaddingRight(),
                                animatedValue);
                        ballView.invalidate();
                    }
                });
            }
        });

        valueAnimator.setDuration(2000);
        valueAnimator.setRepeatMode(ValueAnimator.REVERSE);
        valueAnimator.setRepeatCount(ValueAnimator.INFINITE);
        valueAnimator.setInterpolator(
                new AccelerateInterpolator());
        valueAnimator.start();
    }


    public void rotateAnimation(View view) {

        Animator anim = AnimatorInflater
                .loadAnimator(this, R.animator.rotate);
        anim.setTarget(ballView);
        anim.start();

    }

    public void scaleAnimation(View view) {

        Animator anim = AnimatorInflater
                .loadAnimator(this, R.animator.scale);
        anim.setTarget(ballView);
        anim.start();

    }

    public void translateAnimation(View view) {

        Animator anim = AnimatorInflater
                .loadAnimator(this, R.animator.translate);
        anim.setTarget(ballView);
        anim.start();

    }

    public void alphaAnimation(View view) {

        Animator anim = AnimatorInflater
                .loadAnimator(this, R.animator.alpha);
        anim.setTarget(ballView);
        anim.start();

    }

    public void setAnimation(View view) {

        Animator anim = AnimatorInflater
                .loadAnimator(this, R.animator.set);
        anim.setTarget(ballView);
        anim.start();

    }

}
