package com.holidaypirates.userposts.data;

import android.support.annotation.NonNull;

import com.holidaypirates.userposts.networking.services.CommentsServiceAPI;
import com.holidaypirates.userposts.networking.services.PhotosServiceAPI;
import com.holidaypirates.userposts.networking.services.PostServiceAPI;
import com.holidaypirates.userposts.networking.services.UsersServiceAPI;

/**
 * {@link MainRepositories -- to instantiate {@link PhotosRepository},{@link UsersRepository} and {@link CommentsRepository}}
 *
 * @author Sanjay Mallur
 */

public class MainRepositories {
    private static PhotosRepository mPhotosRepository = null;
    private static UsersRepository mUsersRepository = null;
    private static CommentsRepository mCommentsRepository;
    private static PostRepository repository = null;//repository instance

    private MainRepositories() {
        //Default constructor
    }

    /**
     * Synchronized  method to instantiate PostManager API
     *
     * @param postServiceAPI interface to get callback
     * @return repository returning postManager API
     */
    public static synchronized PostRepository getPostManager(@NonNull PostServiceAPI postServiceAPI) {
        if (repository == null) {
            repository = new PostManager(postServiceAPI);
        }
        return repository;
    }


    /**
     * Returning the instance of PhotosManager
     *
     * @param photosServiceAPI service API
     * @return mPhotosRepository photos repository instance
     */
    public static PhotosRepository getPostsDetailManager(@NonNull PhotosServiceAPI photosServiceAPI) {
        if (mPhotosRepository == null) {
            mPhotosRepository = new PhotosManager(photosServiceAPI);
        }
        return mPhotosRepository;
    }

    /**
     * Returning the instance of UsersManager
     *
     * @param usersServiceAPI service API
     * @return mUsersRepository photos repository instance
     */
    public static synchronized UsersRepository getUsersManager(@NonNull UsersServiceAPI usersServiceAPI) {
        if (mUsersRepository == null) {
            mUsersRepository = new UsersManager(usersServiceAPI);
        }
        return mUsersRepository;
    }

    /**
     * Returning the instance of CommentsManager
     *
     * @param commentsServiceAPI service API
     * @return mCommentsRepository photos repository instance
     */
    public static synchronized CommentsRepository getCommentsManager(@NonNull CommentsServiceAPI commentsServiceAPI) {
        if (mCommentsRepository == null) {
            mCommentsRepository = new CommentsManager(commentsServiceAPI);
        }
        return mCommentsRepository;
    }


}
