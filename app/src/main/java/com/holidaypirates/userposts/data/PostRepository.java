package com.holidaypirates.userposts.data;

import android.support.annotation.NonNull;

import com.holidaypirates.userposts.model.Post;

import java.util.List;

/**
 * {@link PostRepository--Interface to give callback to with data to presenter}
 * @author Sanjay Mallur
 */
@FunctionalInterface
public interface PostRepository {
    @FunctionalInterface
        interface LoadPostsCallback {

        void onPostsLoaded(List<Post> posts);
    }

    void getPosts(@NonNull LoadPostsCallback callback, boolean loadMore, boolean forceUpdate);

}
