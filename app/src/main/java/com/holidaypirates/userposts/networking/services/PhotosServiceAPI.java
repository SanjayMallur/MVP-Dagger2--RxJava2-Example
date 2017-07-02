package com.holidaypirates.userposts.networking.services;

import com.holidaypirates.userposts.model.Photos;

import java.util.List;

/**
 * {@link PhotosServiceAPI --Interface to get the photos data from API}.
 * @author Sanjay Mallur
 */
@FunctionalInterface
public interface PhotosServiceAPI {
    @FunctionalInterface
    interface PhotosServiceCallBack<T>{
        void onPhotosLoaded(T photos);
    }
    void getPhotos(PhotosServiceCallBack<List<Photos>> photosCallBack);

}
