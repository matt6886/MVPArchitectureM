package com.matt.mvparchitecturem.di.component;

import android.app.Application;
import android.content.Context;

import com.matt.mvparchitecturem.MvpApp;
import com.matt.mvparchitecturem.data.DataManager;
import com.matt.mvparchitecturem.di.ApplicationContext;
import com.matt.mvparchitecturem.di.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    void inject(MvpApp app);

    @ApplicationContext
    Context context();

    Application application();

    DataManager getDataManager();
}
