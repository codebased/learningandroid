package com.imcodebased.customviews;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by codebased on 16/08/16.
 */
public class LikeView extends LinearLayout {

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
