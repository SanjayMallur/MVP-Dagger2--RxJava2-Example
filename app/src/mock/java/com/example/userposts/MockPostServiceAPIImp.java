package com.example.userposts;

import com.example.userposts.model.Post;
import com.example.userposts.networking.services.PostServiceAPI;

import java.util.ArrayList;
import java.util.List;

/**
 * Class to load mock data on UI
 * @author Sanjay Mallur
 */
public class MockPostServiceAPIImp implements PostServiceAPI {

    @Override
    public void getPosts(final PostServiceAPI.PostServiceCallback<List<Post>> callback, int offset) {
        List<Post> postList = new ArrayList<>();
        Post post1 = new Post();
        post1.setId("1");
        post1.setBody("mock");
        post1.setTitle("mock title");
        post1.setUserId(1);
        postList.add(post1);
        callback.onPostsLoaded(postList);
    }
}