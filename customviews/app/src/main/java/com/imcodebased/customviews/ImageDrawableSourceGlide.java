
package com.imcodebased.customviews;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.DrawableRequestBuilder;
import com.bumptech.glide.DrawableTypeRequest;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;

public class ImageDrawableSourceGlide {
    private String mUrl;
    private int mResId;
    private int mPlaceHolderResId;
    private int mErrorResId;

    private ImageDrawableSourceGlide(int placeholderResId, int errResId) {
        mPlaceHolderResId = placeholderResId;
        mErrorResId = errResId;
    }

    public ImageDrawableSourceGlide(String url) {
        this(url, 0, 0);
        mUrl = url;
    }

    public ImageDrawableSourceGlide(String url, int placeholderResId, int errResId) {
        this(placeholderResId, errResId);
        mUrl = url;
    }

    public ImageDrawableSourceGlide(int resId) {
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
        RequestManager glide = Glide.with(context);
        glide.load(mUrl).diskCacheStrategy(DiskCacheStrategy.NONE).placeholder(mPlaceHolderResId).error(mErrorResId).into(imageView);
    }

    private void applyUrlImage(Context context, ImageView imageView) {
        applyTo(context, imageView, null);
    }
}