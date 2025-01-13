package com.matt.mvparchitecturem.ui.login;

import android.util.Log;

import com.androidnetworking.error.ANError;
import com.matt.mvparchitecturem.R;
import com.matt.mvparchitecturem.data.DataManager;
import com.matt.mvparchitecturem.data.network.model.LoginRequest;
import com.matt.mvparchitecturem.data.network.model.LoginResponse;
import com.matt.mvparchitecturem.ui.base.BasePresenter;
import com.matt.mvparchitecturem.ui.base.MvpPresenter;
import com.matt.mvparchitecturem.ui.base.MvpView;
import com.matt.mvparchitecturem.utils.CommonUtils;
import com.matt.mvparchitecturem.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

public class LoginPresenter<V extends LoginMvpView> extends BasePresenter<V> implements LoginMvpPresenter<V> {
    private static final String TAG = "LoginPresenter";
    @Inject
    public LoginPresenter(DataManager dataManager,
                          SchedulerProvider schedulerProvider,
                          CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }


    @Override
    public void onServerLoginClick(String email, String password) {
        if (email == null || email.isEmpty()) {
            getMvpView().onError(R.string.empty_email);
            return;
        }
        if (!CommonUtils.isEmailValid(email)) {
            getMvpView().onError(R.string.invalid_email);
            return;
        }
        if (password == null || password.isEmpty()) {
            getMvpView().onError(R.string.empty_password);
            return;
        }
        getMvpView().showLoading();

        getCompositeDisposable().add(getDataManager()
                .doServerLoginApiCall(new LoginRequest.ServerLoginRequest(email, password))
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<LoginResponse>() {
                    @Override
                    public void accept(LoginResponse response) throws Exception {
                        getDataManager().updateUserInfo(
                                response.getAccessToken(),
                                response.getUserId(),
                                DataManager.LoggedInMode.LOGGED_IN_MODE_SERVER,
                                response.getUserName(),
                                response.getUserEmail(),
                                response.getServerProfilePicUrl()
                        );

                        if (!isViewAttached()) {
                            return;
                        }

                        getMvpView().hideLoading();


                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        if (!isViewAttached()) {
                            return;
                        }
                        getMvpView().hideLoading();

                        if (throwable instanceof ANError) {
                            ANError anError = (ANError) throwable;
                            handleApiError(anError);
                        }
                    }
                })
        );
    }

    @Override
    public void onGoogleLoginClick() {
        Log.d(TAG, "onGoogleLoginClick");
    }

    @Override
    public void onFacebookLoginClick() {
        Log.d(TAG, "onFacebookLoginClick");
    }
}
