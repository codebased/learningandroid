package com.imcodebased.dagger;

import android.app.Application;

import com.imcodebased.dagger.daggercomponents.AppComponent;
import com.imcodebased.dagger.daggercomponents.DaggerAppComponent;
import com.imcodebased.dagger.daggermodules.AppModule;
import com.imcodebased.dagger.daggermodules.DataModule;

public class DaggerApplication extends Application {

    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        // Dagger<YourComponentName> class is created with the first build automatically.
        mAppComponent = DaggerAppComponent.builder().
                appModule(new AppModule(this)).
                dataModule(new DataModule()).build();
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }
}


