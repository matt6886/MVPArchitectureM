package com.matt.mvparchitecturem.di.module;

import android.app.Application;
import android.content.Context;

import com.matt.mvparchitecturem.BuildConfig;
import com.matt.mvparchitecturem.data.AppDataManager;
import com.matt.mvparchitecturem.data.DataManager;
import com.matt.mvparchitecturem.data.db.AppDbHelper;
import com.matt.mvparchitecturem.data.db.DbHelper;
import com.matt.mvparchitecturem.data.network.ApiHelper;
import com.matt.mvparchitecturem.data.network.AppApiHelper;
import com.matt.mvparchitecturem.data.prefs.AppPreferenceHelper;
import com.matt.mvparchitecturem.data.prefs.PreferenceHelper;
import com.matt.mvparchitecturem.di.ApiInfo;
import com.matt.mvparchitecturem.di.ApplicationContext;
import com.matt.mvparchitecturem.di.DatabaseInfo;
import com.matt.mvparchitecturem.di.PreferenceInfo;
import com.matt.mvparchitecturem.utils.AppConstants;
import com.mindorks.framework.mvp.data.network.ApiHeader;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {
    private final Application mApplication;

    public ApplicationModule(Application application) { mApplication = application; }

    @Provides
    @ApplicationContext
    Context provideContext() { return  mApplication; }

    @Provides
    Application provideApplication() { return mApplication; }

    @Provides
    @DatabaseInfo
    String provideDatabaseName() { return AppConstants.DB_NAME; }

    @Provides
    @ApiInfo
    String provideApiKey() { return BuildConfig.API_KEY; }

    @Provides
    @PreferenceInfo
    String providePreferenceName() { return  AppConstants.PREF_NAME; }

    @Provides
    @Singleton
    DataManager ProvideDataManager(AppDataManager appDataManager) {
        return  appDataManager;
    }

    @Provides
    @Singleton
    DbHelper provideDbHelper(AppDbHelper appDbHelper) {
        return appDbHelper;
    }

    @Provides
    @Singleton
    PreferenceHelper providePreferenceHelper(AppPreferenceHelper appPreferenceHelper) {
        return  appPreferenceHelper;
    }

    @Provides
    @Singleton
    ApiHelper provideApiHelper(AppApiHelper appApiHelper) {
        return appApiHelper;
    }

    @Provides
    @Singleton
    ApiHeader.ProtectedApiHeader provideProtectedApiHeader(@ApiInfo String apiKey,
                                                           PreferenceHelper preferenceHelper) {
        return new ApiHeader.ProtectedApiHeader(
                apiKey,
                preferenceHelper.getCurrentUserId(),
                preferenceHelper.getAccessToken()
        );
    }

//    @Provides
//    @Singleton
//    ApiHeader.PublicApiHeader provide
}
