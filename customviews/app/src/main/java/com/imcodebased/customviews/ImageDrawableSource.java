
package com.imcodebased.customviews;

import android.content.Context;
import android.widget.ImageView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;

public class ImageDrawableSource {
    private String mUrl;
    private int mResId;
    private int mPlaceHolderResId;
    private int mErrorResId;

    private ImageDrawableSource(int placeholderResId, int errResId) {
        mPlaceHolderResId = placeholderResId;
        mErrorResId = errResId;
    }

    public ImageDrawableSource(String url) {
        this(url, 0, 0);
        mUrl = url;
    }

    public ImageDrawableSource(String url, int placeholderResId, int errResId) {
        this(placeholderResId, errResId);
        mUrl = url;
    }

    public ImageDrawableSource(int resId) {
        mResId = resId;
    }

    public void applyTo(Context context, ImageView imageView) {
        if (mUrl != null && mUrl.length() > 0) {
            applyUrlImage(context, imageView);
        } else if (mResId > 0) {
            imageView.setImageResource(mResId);
        } else if (mErrorResId > 0) {
            imageView.setImageResource(mErrorResId);
        } else {
            imageView.setImageResource(android.R.color.transparent);
        }
    }

    public void applyTo(Context context, ImageView imageView, Callback callback) {
        Picasso picasso = Picasso.with(context);
        RequestCreator requestCreator = picasso.load(mUrl);

        if (mPlaceHolderResId > 0) {
            requestCreator = requestCreator.placeholder(mPlaceHolderResId);
        }

        if (mErrorResId > 0) {
            requestCreator = requestCreator.error(mErrorResId);
        }

        if (callback == null)
            requestCreator.into(imageView);
        else
            requestCreator.into(imageView, callback);
    }

    private void applyUrlImage(Context context, ImageView imageView) {
        applyTo(context, imageView, null);
    }
}