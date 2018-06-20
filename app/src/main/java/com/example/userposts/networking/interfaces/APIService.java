package com.example.userposts.networking.interfaces;

import com.example.userposts.model.Comment;
import com.example.userposts.model.Photos;
import com.example.userposts.model.Post;
import com.example.userposts.model.User;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * API interface to hit API service with retrofit client
 * @author Sanjay Mallur
 */
public interface APIService {
    //Call for posts with limit as 20 per page
    @GET("posts?_limit=20")
    Observable<List<Post>> getPosts(@Query("_start") int start);
    //Call for photos with limit as 20 per page
    @GET("photos?_limit=20")
    Observable<List<Photos>> getPhotos();
    //Call for comments as per post ID
    @GET("posts/{postId}/comments")
    Observable<List<Comment>> getComments(@Path("postId") int postId);
    //Call for users
    @GET("users")
    Observable<List<User>> getUsers();

}
