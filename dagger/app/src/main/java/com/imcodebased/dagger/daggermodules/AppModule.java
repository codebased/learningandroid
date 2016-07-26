package com.imcodebased.dagger.daggermodules;

import android.app.Application;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


/// module contains providers that has object knowledge on what to inject.
@Module
public class AppModule {

    private final Application mApplication;

    public AppModule(Application application) {
        mApplication = application;
    }

    //  you can use @Named("...") though it is not required.
    @Provides
    @Singleton
    public Application provideApplication() {
        return mApplication;
    }
}