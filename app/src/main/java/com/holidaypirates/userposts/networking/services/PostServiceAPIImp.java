package com.holidaypirates.userposts.networking.services;

import android.util.Log;

import com.holidaypirates.userposts.AppApplication;
import com.holidaypirates.userposts.model.Post;
import com.holidaypirates.userposts.networking.interfaces.APIService;
import com.holidaypirates.userposts.util.Utils;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Retrofit;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * {@link PostServiceAPIImp --Getting posts list response from API as List}.
 * @author Sanjay Mallur
 */
public class PostServiceAPIImp implements PostServiceAPI {
    @Inject
    Retrofit retrofit;

    @Override
    public void getPosts(final PostServiceCallback<List<Post>> callback, int offset) {
        AppApplication.getNetComponent().inject(this);
        APIService apiService=retrofit.create(APIService.class);
        Observable<List<Post>> callListPosts = apiService.getPosts(offset);
        callListPosts.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<Post>>() {
                    @Override
                    public void onCompleted() {
                        //Nothing
                    }

                    @Override
                    public void onError(Throwable e) {
                        Utils.showTechnicalErrorDialog(e);
                        Log.e("PostServiceAPIImp",Log.getStackTraceString(e));

                    }

                    @Override
                    public void onNext(List<Post> posts) {
                        callback.onPostsLoaded(posts);
                    }
                });
    }


}
