package com.holidaypirates.userposts.networking.services;

import android.util.Log;

import com.holidaypirates.userposts.model.Photos;
import com.holidaypirates.userposts.util.API;

import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;

/**
 * {@link PhotosServiceAPIImp --Getting photos list response from API as List}.
 * @author Sanjay Mallur
 */

public class PhotosServiceAPIImp implements PhotosServiceAPI {
    private static final String TAG="PhotosServiceAPI";

    @Override
    public void getPhotos(final PhotosServiceCallBack<List<Photos>> callBack) {
        Call<List<Photos>> callPhotosList = API.get().getRetrofitService().getPhotos();
        callPhotosList.enqueue(new Callback<List<Photos>>() {
            @Override
            public void onResponse(Response<List<Photos>> response) {
                callBack.onPhotosLoaded(response.body());
            }

            @Override
            public void onFailure(Throwable t) {
                Log.e(TAG,Log.getStackTraceString(t));
            }
        });
    }




}
