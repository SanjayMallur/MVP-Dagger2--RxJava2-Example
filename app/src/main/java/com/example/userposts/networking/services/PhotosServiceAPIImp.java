package com.example.userposts.networking.services;

import android.util.Log;

import com.example.userposts.AppApplication;
import com.example.userposts.model.Photos;
import com.example.userposts.networking.interfaces.APIService;
import com.example.userposts.util.Utils;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Retrofit;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * {@link PhotosServiceAPIImp --Getting photos list response from API as List}.
 * @author Sanjay Mallur
 */

public class PhotosServiceAPIImp implements PhotosServiceAPI {
    private static final String TAG="PhotosServiceAPI";
    @Inject
    Retrofit retrofit;


    @Override
    public void getPhotos(final PhotosServiceCallBack<List<Photos>> callBack) {
        AppApplication.getNetComponent().inject(this);
        APIService apiService=retrofit.create(APIService.class);
        rx.Observable<List<Photos>> callPhotosList = apiService.getPhotos();
        callPhotosList.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<Photos>>() {
                    @Override
                    public void onCompleted() {
                        //nothing
                    }

                    @Override
                    public void onError(Throwable e) {
                        Utils.showTechnicalErrorDialog(e);
                        Log.e(TAG,Log.getStackTraceString(e));
                    }

                    @Override
                    public void onNext(List<Photos> photoses) {
                        callBack.onPhotosLoaded(photoses);
                    }
                });
    }




}
