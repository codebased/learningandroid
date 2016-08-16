package com.imcodebased.customviews;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by codebased on 16/08/16.
 */
public class AppVersionTextView extends TextView {

    // use it with java.
    public AppVersionTextView(Context context) {
        super(context);
        setVersion();
    }

    // use it with xml
    public AppVersionTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setVersion();
    }

    // use it with xml + can pass style.
    public AppVersionTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setVersion();
    }

    private void setVersion() {
        if (isInEditMode()) {
            setText("AppVersionTextView");
        } else {
            try {
                PackageInfo packageInfo = getContext().getPackageManager().getPackageInfo(getContext().getPackageName(), 0);
                setText(String.format("%1$s %2$d", packageInfo.versionName, packageInfo.versionCode));
            } catch (PackageManager.NameNotFoundException exception) {

            }
        }
    }

}
