package com.imcodebased.customviews;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by codebased on 16/08/16.
 */
public class LikeView extends LinearLayout {

    private static final String EXTRA_LIKES = "EXTRA_LIKES";
    private static final String EXTRA_SUPER_STATE = "EXTRA_SUPER_STATE";
    private TextView textView;
    private ImageView likeButtonImageView;
    private int count;

    public LikeView(Context context) {
        super(context);
        init();
    }

    public LikeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public LikeView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @Override
    protected void onRestoreInstanceState(Parcelable state) {

        if (state instanceof Bundle) {
            Bundle bundle = (Bundle) state;
            count = bundle.getInt(EXTRA_LIKES);
            textView.setText(count + " likes");
            super.onRestoreInstanceState(bundle.getParcelable(EXTRA_SUPER_STATE));
        } else {
            super.onRestoreInstanceState(state);
        }
    }

    @Override
    protected Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable(EXTRA_SUPER_STATE, super.onSaveInstanceState());
        bundle.putInt(EXTRA_LIKES, count);

        return bundle;
    }

    private void init() {
        count = 0;
        inflate(getContext(), R.layout.likeview, this);
        likeButtonImageView = (ImageView) findViewById(R.id.likeButton);
        textView = (TextView) findViewById(R.id.textView);
        likeButtonImageView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                textView.setText(count + " likes");
            }
        });
    }
}
