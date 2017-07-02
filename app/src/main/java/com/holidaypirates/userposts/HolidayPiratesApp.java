package com.holidaypirates.userposts;

import android.app.Application;
import android.content.Context;

import com.squareup.leakcanary.LeakCanary;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * BaseApplication to app for defining configurations for whole application
 * @author Sanjay Mallur
 */
public class HolidayPiratesApp extends Application {

    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);//To check for memory leaks
        mContext = this;
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder(this).build();
        Realm.setDefaultConfiguration(realmConfiguration);
    }

    public static Context getContext() {
        return mContext;
    }


}
