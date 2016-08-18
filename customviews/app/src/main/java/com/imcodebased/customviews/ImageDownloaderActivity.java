package com.imcodebased.customviews;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by codebased on 18/08/16.
 */
public class ImageDownloaderActivity extends AppCompatActivity implements View.OnClickListener {


    private Button picassoWayButtonView;
    private Button glideWayButtonView;
    private ImageView imageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_downloader);
        picassoWayButtonView = (Button) findViewById(R.id.picassoWay);
        glideWayButtonView = (Button) findViewById(R.id.glideWay);
        imageView = (ImageView) findViewById(R.id.imageView);
        glideWayButtonView.setOnClickListener(this);
        picassoWayButtonView.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.glideWay:
                loadGlide();
                break;
            case R.id.picassoWay:
                loadPicasso();
                break;
        }
    }

    private void loadGlide() {
        new ImageDrawableSourceGlide("https://media.licdn.com/mpr/mpr/shrinknp_400_400/p/5/005/07b/011/249cc11.jpg", R.drawable.ic_blank, R.drawable.ic_image_not_found).
                applyTo(this, imageView);
    }

    private void loadPicasso() {
        new ImageDrawableSource("https://media.licdn.com/mpr/mpr/shrinknp_400_400/p/5/005/07b/011/249cc11.jpg", R.drawable.ic_blank, R.drawable.ic_image_not_found).
                applyTo(this, imageView);
    }
}
