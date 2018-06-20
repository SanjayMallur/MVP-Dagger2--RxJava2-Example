package com.example.userposts.networking.services;

import android.util.Log;

import com.example.userposts.AppApplication;
import com.example.userposts.model.Comment;
import com.example.userposts.networking.interfaces.APIService;
import com.example.userposts.util.Utils;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Retrofit;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * {@link CommentsServiceAPIImp --Getting comments list response from API as List}.
 * @author Sanjay Mallur
 */

public class CommentsServiceAPIImp implements CommentsServiceAPI {
    private static final String TAG="CommentsServiceAPIImp";
    @Inject
    Retrofit retrofit;

    @Override
    public void getComments(final CommentsServiceCallBack<List<Comment>> commentsCallBack,int postId) {
        AppApplication.getNetComponent().inject(this);
        APIService apiService=retrofit.create(APIService.class);

        Observable<List<Comment>> callCommentsList= apiService.getComments(postId);
        callCommentsList.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<Comment>>() {
                    @Override
                    public void onCompleted() {
                    //Nothing to be implemented
                    }

                    @Override
                    public void onError(Throwable e) {
                        Utils.showTechnicalErrorDialog(e);
                        Log.e(TAG,Log.getStackTraceString(e));//Failed to fetch comments
                    }

                    @Override
                    public void onNext(List<Comment> comments) {
                        commentsCallBack.onCommentsLoaded(comments);
                    }
                });
    }

}
