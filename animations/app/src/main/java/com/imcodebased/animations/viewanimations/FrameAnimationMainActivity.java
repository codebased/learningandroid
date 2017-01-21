package com.imcodebased.animations.viewanimations;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.imcodebased.animations.R;

public class FrameAnimationMainActivity extends AppCompatActivity {

    private ImageView dummyFrame;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_animation);
        dummyFrame = (ImageView) findViewById(R.id.imageView);
    }

    public void loadFrameAnimation(View view) {
        dummyFrame.setBackgroundResource(R.drawable.stickmanframeanimationrepeat);

        AnimationDrawable frameAnimation = (AnimationDrawable) dummyFrame.getBackground();

        if (frameAnimation.isRunning()) {
            frameAnimation.stop();
        } else {
            frameAnimation.stop();
            frameAnimation.start();
        }
    }

    // to do reverse transaction try using TransitionDrawable resetTransition.
    public void loadSelectedFrameAnimation(View view) {
        dummyFrame.setBackgroundResource(R.drawable.statebasedframeanimation);

        dummyFrame.setActivated(!dummyFrame.isActivated());
    }
}
