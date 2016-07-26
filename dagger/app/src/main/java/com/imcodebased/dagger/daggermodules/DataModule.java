package com.imcodebased.dagger.daggermodules;

import android.app.Application;

import com.imcodebased.dagger.ArrayDataProvider;
import com.imcodebased.dagger.DataProvider;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


@Module
public class DataModule {

    @Provides
    @Singleton
    public DataProvider provideDataProvider(Application application) {
        return new ArrayDataProvider(application);
    }
}
