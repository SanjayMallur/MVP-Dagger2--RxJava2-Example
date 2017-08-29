package com.holidaypirates.userposts;

import com.holidaypirates.userposts.data.CommentsRepository;
import com.holidaypirates.userposts.data.MainRepositories;
import com.holidaypirates.userposts.data.PhotosRepository;
import com.holidaypirates.userposts.data.PostRepository;
import com.holidaypirates.userposts.data.UsersRepository;
import com.holidaypirates.userposts.networking.services.CommentsServiceAPIImp;
import com.holidaypirates.userposts.networking.services.PhotosServiceAPIImp;
import com.holidaypirates.userposts.networking.services.PostServiceAPIImp;
import com.holidaypirates.userposts.networking.services.UsersServiceAPIImp;

/**
 * Class to show online and offline data to user when there is state change in network connection
 * @author Sanjay Mallur
 */
public class Injection {

    public static PostRepository providePostsRepository() {
        return MainRepositories.getPostManager( new PostServiceAPIImp());
    }
    public static PhotosRepository providePhotosRepository() {
        return MainRepositories.getPostsDetailManager( new PhotosServiceAPIImp());
    }
    public static CommentsRepository provideCommentsRepository() {
        return MainRepositories.getCommentsManager( new CommentsServiceAPIImp());
    }
    public static UsersRepository provideUsersRepository() {
        return MainRepositories.getUsersManager( new UsersServiceAPIImp());
    }

}