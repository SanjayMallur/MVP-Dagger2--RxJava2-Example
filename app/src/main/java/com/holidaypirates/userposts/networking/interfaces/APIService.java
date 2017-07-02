package com.holidaypirates.userposts.networking.interfaces;

import com.holidaypirates.userposts.model.Comment;
import com.holidaypirates.userposts.model.Photos;
import com.holidaypirates.userposts.model.Post;
import com.holidaypirates.userposts.model.User;

import java.util.List;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * API interface to hit API service with retrofit client
 * @author Sanjay Mallur
 */
public interface APIService {
    //Call for posts with limit as 20 per page
    @GET("posts?_limit=20")
    Call<List<Post>> getPosts(@Query("_start") int start);
    //Call for photos with limit as 20 per page
    @GET("photos?_limit=20")
    Call<List<Photos>> getPhotos();
    //Call for comments as per post ID
    @GET("posts/{postId}/comments")
    Call<List<Comment>> getComments(@Path("postId") String postId);
    //Call for users
    @GET("users")
    Call<List<User>> getUsers();

}
