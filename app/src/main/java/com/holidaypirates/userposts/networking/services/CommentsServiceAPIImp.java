package com.holidaypirates.userposts.networking.services;

import android.util.Log;

import com.holidaypirates.userposts.model.Comment;
import com.holidaypirates.userposts.util.API;
import com.holidaypirates.userposts.util.Utils;

import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;

/**
 * {@link CommentsServiceAPIImp --Getting comments list response from API as List}.
 * @author Sanjay Mallur
 */

public class CommentsServiceAPIImp implements CommentsServiceAPI {
    private static final String TAG="CommentsServiceAPIImp";


    @Override
    public void getComments(final CommentsServiceCallBack<List<Comment>> commentsCallBack,int postId) {
        Call<List<Comment>> callCommentsList= API.get().getRetrofitService().getComments(postId);
        callCommentsList.enqueue(new Callback<List<Comment>>() {
            @Override
            public void onResponse(Response<List<Comment>> response) {
                commentsCallBack.onCommentsLoaded(response.body());//adding data
            }

            @Override
            public void onFailure(Throwable t) {
                Utils.showTechnicalErrorDialog(t);
                Log.e(TAG,Log.getStackTraceString(t));//Failed to fetch comments

            }
        });
    }

}
