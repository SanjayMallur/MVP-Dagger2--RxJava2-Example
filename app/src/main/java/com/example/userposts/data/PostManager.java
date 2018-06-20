package com.example.userposts.data;

import android.support.annotation.NonNull;

import com.example.userposts.model.Post;
import com.example.userposts.networking.services.PostServiceAPI;

import java.util.ArrayList;
import java.util.List;

/**
 * {@link PostManager --To get the comments from service API and adding to list}
 *
 * @author Sanjay Mallur
 */
public class PostManager implements PostRepository {

    private PostServiceAPI mPostServiceApi;//Interface to get the data from service API
    private List<Post> mPosts = new ArrayList<>();//List to add comments
    /**
     * Constructor called From Repositories
     *
     * @param postServiceAPI interface
     */
    public PostManager(@NonNull PostServiceAPI postServiceAPI) {
        mPostServiceApi = postServiceAPI;
    }

    @Override
    public void getPosts(@NonNull final LoadPostsCallback callback, boolean loadMore, boolean forceUpdate) {
        if (forceUpdate) {
            mPosts.clear();
        }
        if (!loadMore && !mPosts.isEmpty()) {//Checking is not loadMore request and list is not empty to add items
            callback.onPostsLoaded(mPosts);
        } else {
            //Calling more items to add it to bottom of the list with size as limit parameter to get next items from service
            mPostServiceApi.getPosts(new PostServiceAPI.PostServiceCallback<List<Post>>() {
                @Override
                public void onPostsLoaded(List<Post> posts) {
                    mPosts.addAll(new ArrayList<>(posts));//adding all items to list
                    callback.onPostsLoaded(mPosts);
                }
            }, mPosts.size());
        }
    }
    /**
     * Constructor called From Repositories
     * @param postServiceAPI interface
     */
    public void switchAPILayer(@NonNull PostServiceAPI postServiceAPI) {
        this.mPostServiceApi = postServiceAPI;
    }
}
