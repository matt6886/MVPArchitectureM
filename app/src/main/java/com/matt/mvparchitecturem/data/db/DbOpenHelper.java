package com.matt.mvparchitecturem.data.db;

import android.content.Context;

import com.matt.mvparchitecturem.data.db.model.DaoMaster;
import com.matt.mvparchitecturem.di.ApplicationContext;
import com.matt.mvparchitecturem.di.DatabaseInfo;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class DbOpenHelper extends DaoMaster.OpenHelper {

    @Inject
    public DbOpenHelper(@ApplicationContext Context context, @DatabaseInfo String name) {
        super(context, name);
    }
}
