package com.matt.mvparchitecturem;

import android.app.Application;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.interceptors.HttpLoggingInterceptor;
import com.matt.mvparchitecturem.data.DataManager;
import com.matt.mvparchitecturem.di.component.ApplicationComponent;
import com.matt.mvparchitecturem.di.component.DaggerApplicationComponent;
import com.matt.mvparchitecturem.di.module.ApplicationModule;

import javax.inject.Inject;

public class MvpApp extends Application {
    @Inject
    DataManager mDataManager;

    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this)).build();
        mApplicationComponent.inject(this);

        AndroidNetworking.initialize(getApplicationContext());

        if (BuildConfig.DEBUG) {
            AndroidNetworking.enableLogging(HttpLoggingInterceptor.Level.BODY);
        }
    }

    public ApplicationComponent getComponent() { return  mApplicationComponent; }

    public void setComponent(ApplicationComponent applicationComponent) {
        mApplicationComponent = applicationComponent;
    }
}
