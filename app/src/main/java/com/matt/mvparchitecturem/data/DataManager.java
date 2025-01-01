package com.matt.mvparchitecturem.data;

import com.matt.mvparchitecturem.data.db.DbHelper;
import com.matt.mvparchitecturem.data.network.ApiHelper;
import com.matt.mvparchitecturem.data.prefs.PreferenceHelper;

import io.reactivex.Observable;

public interface DataManager extends DbHelper, PreferenceHelper, ApiHelper {
    void updateApiHeader(Long userId, String accessToken);

    void setUserAsLoggedOut();

    Observable<Boolean> seedDatabaseQuestions();

    Observable<Boolean> seedDatabaseOptions();

    void updateUserInfo(
            String accessToken,
            Long userId,
            LoggedInMode loggedInMode,
            String userName,
            String email,
            String profilePicPath);

    enum LoggedInMode {
        LOGGED_IN_MODE_LOGGED_OUT(0),
        LOGGED_IN_MODE_GOOGLE(1),
        LOGGED_IN_MODE_FB(2),
        LOGGED_IN_MODE_SERVER(3);

        private final int mType;

        LoggedInMode(int type) {
            mType = type;
        }

        public int getType() {
            return mType;
        }
    }
}
