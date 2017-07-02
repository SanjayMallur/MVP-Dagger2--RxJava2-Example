package com.holidaypirates.userposts.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.holidaypirates.userposts.data.MainRepositories;

/**
 * {@link NetworkStateReceiver -- Class to check for network state change behaviour}
 *
 * @author Sanjay Mallur.
 */
public class NetworkStateReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        //Check for intent data
        if (intent.getExtras() != null) {
            final ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            final NetworkInfo ni = connectivityManager.getActiveNetworkInfo();
            MainRepositories.changeOffLineRepository(ni != null && ni.isConnectedOrConnecting());
        }
    }

}
