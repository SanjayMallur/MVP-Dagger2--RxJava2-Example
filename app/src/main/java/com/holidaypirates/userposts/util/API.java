package com.holidaypirates.userposts.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.holidaypirates.userposts.networking.interfaces.APIService;

/**
 * Class to instantiate API service with Retrofit
 *
 * @author Sanjay Mallur
 */
public class API {

    private static API instance;

    private APIService service;

    private API() {
        /* IGNORED */
    }

    public static API get() {
        if (instance == null) {
            instance = new API();
        }
        return instance;
    }

    /**
     * Method check for internet connection
     *
     * @return boolean
     */
    public static boolean isConnected(Context mContext) {
        ConnectivityManager conMgr = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo i = conMgr.getActiveNetworkInfo();
        if (i == null)
            return false;
        if (!i.isConnected())
            return false;
        if (!i.isAvailable())
            return false;
        return true;
    }

}
