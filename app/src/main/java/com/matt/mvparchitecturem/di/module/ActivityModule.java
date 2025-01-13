package com.matt.mvparchitecturem.di.module;

import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;

import com.matt.mvparchitecturem.di.ActivityContext;
import com.matt.mvparchitecturem.di.PerActivity;
import com.matt.mvparchitecturem.ui.login.LoginMvpPresenter;
import com.matt.mvparchitecturem.ui.login.LoginMvpView;
import com.matt.mvparchitecturem.ui.login.LoginPresenter;
import com.matt.mvparchitecturem.ui.splash.SplashMvpPresenter;
import com.matt.mvparchitecturem.ui.splash.SplashMvpView;
import com.matt.mvparchitecturem.ui.splash.SplashPresenter;
import com.matt.mvparchitecturem.utils.rx.AppSchedulerProvider;
import com.matt.mvparchitecturem.utils.rx.SchedulerProvider;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

@Module
public class ActivityModule {
    AppCompatActivity mActivity;

    public ActivityModule(AppCompatActivity activity) {
        this.mActivity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext() { return  mActivity; }

    @Provides
    AppCompatActivity provideActivity() { return  mActivity; }

    @Provides
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

    @Provides
    SchedulerProvider provideSchedulerProvider() {
        return  new AppSchedulerProvider();
    }

    @Provides
    @PerActivity
    SplashMvpPresenter<SplashMvpView> provideSplashPresenter(
            SplashPresenter<SplashMvpView> presenter
    ) {
        return presenter;
    }

    @Provides
    @PerActivity
    LoginMvpPresenter<LoginMvpView> provideLoginPresenter(
            LoginPresenter<LoginMvpView> presenter
    ) {
        return presenter;
    }

}
