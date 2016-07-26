package com.imcodebased.dagger.daggercomponents;

import android.app.Activity;


import com.imcodebased.dagger.MainActivity;
import com.imcodebased.dagger.daggermodules.AppModule;
import com.imcodebased.dagger.daggermodules.DataModule;

import javax.inject.Singleton;

import dagger.Component;

//  Enable selected modules and used for performing dependency injection
// Singleton is like what it says.
@Singleton

// Component contains list of modules.
// You can depend on other components using dependencies = {} attribute
@Component(modules = {AppModule.class, DataModule.class})
public interface AppComponent {

    // dump ass it cannot accept generic like void inject(Activity activity);
    void inject(MainActivity activity);
}