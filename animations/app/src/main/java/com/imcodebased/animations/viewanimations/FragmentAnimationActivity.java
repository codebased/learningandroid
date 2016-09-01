package com.imcodebased.animations.viewanimations;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.imcodebased.animations.R;

/**
 * Created by codebased on 1/09/16.
 */
public class FragmentAnimationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_animation);

    }

    public void loadFragment1(View view) {
        getSupportFragmentManager().beginTransaction().
                setCustomAnimations(getInAnimation(), getOutAnimation()).
                replace(R.id.container, new Fragment1()).commit();
    }

    public void loadFragment2(View view) {
        getSupportFragmentManager().beginTransaction().
                setCustomAnimations(getInAnimation(), getOutAnimation()).
                replace(R.id.container, new Fragment2()).commit();
    }

    public int getInAnimation() {
        return R.anim.translatein;
    }

    public int getOutAnimation() {
        return R.anim.translateout;
    }
}
