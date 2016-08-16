package com.imcodebased.customviews;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by codebased on 17/08/16.
 */
public class PhotoSquare extends ViewGroup {
    public PhotoSquare(Context context) {
        super(context);
    }

    public PhotoSquare(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PhotoSquare(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onMeasure(int widthSpec, int heightSpec) {
        measureChildren(widthSpec, heightSpec);
        View first = getChildAt(0);
        int size = first.getMeasuredWidth() + first.getMeasuredHeight();
        int width = ViewGroup.resolveSize(size, widthSpec);
        int height = ViewGroup.resolveSize(size, heightSpec);
        setMeasuredDimension(width, height);
    }

    // set each child layout and dictate, which one should go where.
    // You have to call child.layout...
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        View first = getChildAt(0);
        final int childWidth = first.getMeasuredWidth();
        final int childHeight = first.getMeasuredHeight();

        for (int i = 0; i < getChildCount(); ++i) {
            View child = getChildAt(i);
            int x = 0;
            int y = 0;
            switch (i) {
                case 1:
                    x = childWidth;
                    y = 0;
                    break;
                case 2:
                    x = childHeight;
                    y = childWidth;
                    break;
                case 3:
                    x = 0;
                    y = childHeight;
                    break;
            }
            child.layout(x, y,
                    x + child.getMeasuredWidth(), y + child.getMeasuredHeight());
        }
    }
}