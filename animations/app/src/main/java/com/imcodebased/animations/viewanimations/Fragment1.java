package com.imcodebased.animations.viewanimations;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.imcodebased.animations.R;

/**
 * Created by codebased on 1/09/16.
 */
public class Fragment1 extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        LinearLayout view = new LinearLayout(getContext());
        view.setOrientation(LinearLayout.HORIZONTAL);
        view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        ImageView ball = new ImageView(getContext());
        ball.setImageDrawable(getResources().getDrawable(R.drawable.redball));
        view.addView(ball);
        view.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        return view;
    }
}
