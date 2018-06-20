package com.example.userposts.networking.services;

import android.util.Log;

import com.example.userposts.AppApplication;
import com.example.userposts.model.User;
import com.example.userposts.networking.interfaces.APIService;
import com.example.userposts.util.Utils;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Retrofit;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * {@link UsersServiceAPIImp --Getting posts list response from API as List}.
 * @author Sanjay Mallur
 */

public class UsersServiceAPIImp implements UsersServiceAPI {
    private static final String TAG="UsersServiceAPIImp";
    @Inject
    Retrofit retrofit;
    @Override
    public void getUsers(final UsersServiceCallBack<List<User>> usersCallBack) {
        AppApplication.getNetComponent().inject(this);
        APIService apiService=retrofit.create(APIService.class);
        Observable<List<User>> callUsersList= apiService.getUsers();
        callUsersList.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<User>>() {
                    @Override
                    public void onCompleted() {
                     //nothing to be implemented
                    }

                    @Override
                    public void onError(Throwable e) {
                        Utils.showTechnicalErrorDialog(e);
                        Log.e(TAG,Log.getStackTraceString(e));
                    }

                    @Override
                    public void onNext(List<User> users) {
                        usersCallBack.onUsersLoaded(users);
                    }
                });

    }
}
