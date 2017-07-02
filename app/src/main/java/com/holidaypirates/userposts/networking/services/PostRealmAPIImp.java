package com.holidaypirates.userposts.networking.services;

import com.holidaypirates.userposts.model.Post;
import com.holidaypirates.userposts.model.PostRealm;

import java.util.List;

/**
 * {@link PostRealmAPIImp --Getting posts response from database as List}.
 * @author Sanjay Mallur
 */
public class PostRealmAPIImp implements PostServiceAPI {

    @Override
    public void getPosts(PostServiceCallback<List<Post>> callback, int offset) {
        callback.onPostsLoaded(Post.obtainFromResult(PostRealm.getPostsInDatabase()));
    }

}
