package com.holidaypirates.userposts.networking.services;

import android.util.Log;

import com.holidaypirates.userposts.model.User;
import com.holidaypirates.userposts.util.API;
import com.holidaypirates.userposts.util.Utils;

import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;

/**
 * {@link UsersServiceAPIImp --Getting posts list response from API as List}.
 * @author Sanjay Mallur
 */

public class UsersServiceAPIImp implements UsersServiceAPI {
    private static final String TAG="UsersServiceAPIImp";
    @Override
    public void getUsers(final UsersServiceCallBack<List<User>> usersCallBack) {
        Call<List<User>> callUsersList= API.get().getRetrofitService().getUsers();
        callUsersList.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Response<List<User>> response) {
                usersCallBack.onUsersLoaded(response.body());
            }

            @Override
            public void onFailure(Throwable t) {
                Utils.showTechnicalErrorDialog(t);
                Log.e(TAG,Log.getStackTraceString(t));
            }
        });
    }
}
