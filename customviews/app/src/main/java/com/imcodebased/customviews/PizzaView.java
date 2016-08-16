package com.imcodebased.customviews;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by codebased on 16/08/16.
 */
public class PizzaView extends View {

    private Paint paint;
    private int numSlices = 5;

    public PizzaView(Context context) {
        super(context);
        init(context, null);
    }

    public PizzaView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public PizzaView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        if (attrs != null) {
            TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.PizzaView);
            numSlices = array.getInt(R.styleable.PizzaView_slices, numSlices);
        }

        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(4);
        paint.setColor(Color.GREEN);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        final int width = getWidth() - getPaddingLeft() - getPaddingRight();
        final int height = getHeight() - getPaddingTop() - getPaddingBottom();
        final int cx = width / 2 + getPaddingLeft();
        final int cy = height / 2 + getPaddingTop();

        final float diameter = Math.min(width, height) - paint.getStrokeWidth();
        final float radius = diameter / 2;

        canvas.drawCircle(cx, cy, radius, paint);
        drawPizzaCuts(canvas, cx, cy, radius);
    }

    private void drawPizzaCuts(Canvas canvas, int cx, int cy, float radius) {

        final float degrees = 360f / numSlices;
        canvas.save();
        for (int idx = 0; idx < numSlices; ++idx) {
            canvas.rotate(degrees, cx, cy);
            canvas.drawLine(cx, cy, cx, cy - radius, paint);
        }
        canvas.restore();
    }
}
