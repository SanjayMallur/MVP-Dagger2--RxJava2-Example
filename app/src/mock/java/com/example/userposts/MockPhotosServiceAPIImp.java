package com.example.userposts;

import com.example.userposts.model.Photos;
import com.example.userposts.networking.services.PhotosServiceAPI;

import java.util.ArrayList;
import java.util.List;

/**
 * Class to show mock photos data on UI
 * @author Sanjay Mallur
 */

public class MockPhotosServiceAPIImp implements PhotosServiceAPI {
    @Override
    public void getPhotos(PhotosServiceCallBack<List<Photos>> photosCallBack) {
        List<Photos> mPhotosList=new ArrayList<>();
        Photos mPhotos=new Photos();
        mPhotos.setId(1);
        mPhotos.setAlbumId(10);
        mPhotos.setTitle("Blue Sky");
        mPhotos.setUrl("http://placehold.it/600/9c184f");
        mPhotos.setThumbnailUrl("http://placehold.it/150/9c184f");
        mPhotosList.add(mPhotos);
        photosCallBack.onPhotosLoaded(mPhotosList);
    }
}
