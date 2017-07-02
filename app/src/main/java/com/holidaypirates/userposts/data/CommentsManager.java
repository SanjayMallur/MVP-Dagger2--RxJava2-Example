package com.holidaypirates.userposts.data;

import android.support.annotation.NonNull;

import com.holidaypirates.userposts.model.Comment;
import com.holidaypirates.userposts.networking.services.CommentsServiceAPI;

import java.util.ArrayList;
import java.util.List;

/**
 * {@link CommentsManager --To get the comments from service API and adding to list}
 *
 * @author Sanjay Mallur
 */

public class CommentsManager implements CommentsRepository {
    private CommentsServiceAPI mCommentsServiceAPI;//Interface to get the data from service API
    private List<Comment> mComments = new ArrayList<>();//List to add comments

    /**
     * Constructor called From Repositories
     *
     * @param commentsServiceAPI interface
     */
    public CommentsManager(@NonNull CommentsServiceAPI commentsServiceAPI) {
        this.mCommentsServiceAPI = commentsServiceAPI;

    }

    @Override
    public void getComments(@NonNull final LoadCommentsCallBack commentsCallBack, int postId) {
        mComments.clear();
        mCommentsServiceAPI.getComments(new CommentsServiceAPI.CommentsServiceCallBack<List<Comment>>() {
            @Override
            public void onCommentsLoaded(List<Comment> comments) {
                mComments.addAll(new ArrayList<>(comments));//adding data to array list
                commentsCallBack.onCommentsLoaded(mComments);//passing list data to repository
            }
        },postId);

    }



}
