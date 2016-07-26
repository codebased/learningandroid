package com.imcodebased.dagger;

import android.app.Application;

import java.util.Arrays;
import java.util.List;

public class ArrayDataProvider implements DataProvider {

    Application application;

    public ArrayDataProvider(Application application) {
        this.application = application;
    }

    @Override
    public List<String> getData() {
        return Arrays.asList(application.getResources().getStringArray(R.array.list));
    }
}
