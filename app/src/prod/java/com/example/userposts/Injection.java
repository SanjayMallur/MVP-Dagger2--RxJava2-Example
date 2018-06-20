package com.example.userposts;

import com.example.userposts.data.CommentsRepository;
import com.example.userposts.data.MainRepositories;
import com.example.userposts.data.PhotosRepository;
import com.example.userposts.data.PostRepository;
import com.example.userposts.data.UsersRepository;
import com.example.userposts.networking.services.CommentsServiceAPIImp;
import com.example.userposts.networking.services.PhotosServiceAPIImp;
import com.example.userposts.networking.services.PostServiceAPIImp;
import com.example.userposts.networking.services.UsersServiceAPIImp;

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