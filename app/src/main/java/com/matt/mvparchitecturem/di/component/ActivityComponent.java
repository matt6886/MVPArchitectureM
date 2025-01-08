package com.matt.mvparchitecturem.di.component;

import com.matt.mvparchitecturem.di.PerActivity;
import com.matt.mvparchitecturem.di.module.ActivityModule;
import com.matt.mvparchitecturem.ui.splash.SplashActivity;

import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    void inject(SplashActivity activity);
}
