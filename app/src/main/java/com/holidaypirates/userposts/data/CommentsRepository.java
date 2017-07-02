package com.holidaypirates.userposts.data;

import android.support.annotation.NonNull;

import com.holidaypirates.userposts.model.Comment;

import java.util.List;

/**
 * Interface to get callback in Comments manager to load data
 * @author Sanjay Mallur
 * {@link CommentsRepository}
 */
@FunctionalInterface
public interface CommentsRepository  {
    @FunctionalInterface
    interface LoadCommentsCallBack{
        void onCommentsLoaded(List<Comment> comments);//to load comments
    }
    void getComments(@NonNull LoadCommentsCallBack commentsCallBack,String postId);//to get comments from service
}
