package com.matt.mvparchitecturem.data.network;

import com.matt.mvparchitecturem.data.network.model.BlogResponse;
import com.matt.mvparchitecturem.data.network.model.LoginRequest;
import com.matt.mvparchitecturem.data.network.model.LoginResponse;
import com.matt.mvparchitecturem.data.network.model.LogoutResponse;
import com.matt.mvparchitecturem.data.network.model.OpenSourceResponse;
import com.mindorks.framework.mvp.data.network.ApiHeader;

import io.reactivex.Single;

public interface ApiHelper {
    ApiHeader getApiHeader();

    Single<LoginResponse> doGoogleLoginApiCall(LoginRequest.GoogleLoginRequest request);

    Single<LoginResponse> doFacebookLoginApiCall(LoginRequest.FacebookLoginRequest request);

    Single<LoginResponse> doServerLoginApiCall(LoginRequest.ServerLoginRequest request);

    Single<LogoutResponse> doLogoutApiCall();

    Single<BlogResponse> getBlogApiCall();

    Single<OpenSourceResponse> getOpenSourceApiCall();

}
