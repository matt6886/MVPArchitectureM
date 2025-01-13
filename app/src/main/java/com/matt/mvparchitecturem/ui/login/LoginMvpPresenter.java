package com.matt.mvparchitecturem.ui.login;

import com.matt.mvparchitecturem.di.PerActivity;
import com.matt.mvparchitecturem.ui.base.MvpPresenter;
import com.matt.mvparchitecturem.ui.base.MvpView;

@PerActivity
public interface LoginMvpPresenter<V extends LoginMvpView> extends MvpPresenter<V> {

    void onServerLoginClick(String email, String password);

    void onGoogleLoginClick();

    void onFacebookLoginClick();
}
