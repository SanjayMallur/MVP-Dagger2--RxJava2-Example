package com.example.userposts.networking.services;

import com.example.userposts.model.Comment;

import java.util.List;

/**
 * {@link CommentsServiceAPI --Interface to get the comments data from API}.
 * @author Sanjay Mallur
 */
@FunctionalInterface
public interface CommentsServiceAPI {
    @FunctionalInterface
    interface CommentsServiceCallBack<T>{
        void onCommentsLoaded(T comments);//overriding method
    }
    void getComments(CommentsServiceCallBack<List<Comment>> commentsCallBack,int postId);//to get comments from service API with post id
}
