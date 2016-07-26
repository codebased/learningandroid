package com.imcodebased.dagger;

import android.app.Application;

import java.util.List;

/**
 * Created by codebased on 26/07/16.
 */
public interface DataProvider {

    Application application = null;

    List<String> getData();
}
