package com.example.userposts.data;

import android.support.annotation.NonNull;

import com.example.userposts.model.Photos;

import java.util.List;

/**
 * Created by Sanjay on 29-06-2017.
 */
@FunctionalInterface
public interface PhotosRepository {
    @FunctionalInterface
    interface LoadPhotosCallback {
        void onPhotosLoaded(List<Photos> photos);
    }
    void getPhotos(@NonNull LoadPhotosCallback photosCallBack);
}
