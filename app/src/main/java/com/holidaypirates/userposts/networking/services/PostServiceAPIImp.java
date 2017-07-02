package com.holidaypirates.userposts.networking.services;

import android.util.Log;

import com.holidaypirates.userposts.model.Post;
import com.holidaypirates.userposts.util.API;
import com.holidaypirates.userposts.util.Utils;

import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;

/**
 * {@link PostServiceAPIImp --Getting posts list response from API as List}.
 * @author Sanjay Mallur
 */
public class PostServiceAPIImp implements PostServiceAPI {

    @Override
    public void getPosts(final PostServiceCallback<List<Post>> callback, int offset) {
        Call<List<Post>> callListPosts = API.get().getRetrofitService().getPosts(offset);
        callListPosts.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Response<List<Post>> response) {
                callback.onPostsLoaded(response.body());
            }

            @Override
            public void onFailure(Throwable t) {
                Utils.showTechnicalErrorDialog(t);
                Log.e("PostServiceAPIImp",Log.getStackTraceString(t));
            }
        });
    }


}
