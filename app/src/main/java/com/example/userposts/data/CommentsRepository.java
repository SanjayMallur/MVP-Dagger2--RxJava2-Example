package com.example.userposts.data;

import android.support.annotation.NonNull;

import com.example.userposts.model.Comment;

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
    void getComments(@NonNull LoadCommentsCallBack commentsCallBack,int postId);//to get comments from service
}
