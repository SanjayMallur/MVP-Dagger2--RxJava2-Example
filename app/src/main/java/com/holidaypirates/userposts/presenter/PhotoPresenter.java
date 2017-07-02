package com.holidaypirates.userposts.presenter;

import android.support.annotation.NonNull;

import com.holidaypirates.userposts.data.PhotosRepository;
import com.holidaypirates.userposts.model.Photos;
import com.holidaypirates.userposts.ui.postdetail.PostsDetailsContractor;

import java.util.List;

/**
 * {@link PhotoPresenter -- to show photos data on UI after attaching view}
 * @author Sanjay Mallur
 */

public class PhotoPresenter implements PostsDetailsContractor.PhotoPresenter<PostsDetailsContractor.PhotosView> {

    private PostsDetailsContractor.PhotosView mPhotosView;//Comments view
    private PhotosRepository mPhotosRepository;//Comments repository
    /**
     * Constructor called from Comments fragment to inject service request
     *
     * @param photosRepository repository to get the data callback
     */
    public PhotoPresenter(@NonNull PhotosRepository photosRepository){
        mPhotosRepository = photosRepository;
    }

    @Override
    public void loadPhotos() {
        mPhotosRepository.getPhotos(new PhotosRepository.LoadPhotosCallback() {
            @Override
            public void onPhotosLoaded(List<Photos> photos) {
                mPhotosView.showPhotos(photos);//loading photos on UI
            }

        });
    }


    @Override
    public void attachView(PostsDetailsContractor.PhotosView view) {
        this.mPhotosView =view;//attaching view
    }
    @Override
    public void detachView() {
        mPhotosView =null;//detaching view
    }

}
