package com.example.userposts.presenter;

import android.support.annotation.NonNull;

import com.example.userposts.data.CommentsRepository;
import com.example.userposts.model.Comment;
import com.example.userposts.ui.postdetail.PostsDetailsContractor;

import java.util.List;

/**
 * {@link CommentPresenter -- to show comments data on UI after attaching view}
 * @author Sanjay Mallur
 */

public class CommentPresenter implements PostsDetailsContractor.CommentPresenter<PostsDetailsContractor.CommentsView> {

    private PostsDetailsContractor.CommentsView mCommentsView;//Comments view
    private CommentsRepository mCommentsRepository;//Comments repository

    /**
     * Constructor called from Comments fragment to inject service request
     *
     * @param commentsRepository repository to get the data callback
     */
    public CommentPresenter(@NonNull CommentsRepository commentsRepository) {
        mCommentsRepository = commentsRepository;
    }


    @Override
    public void attachView(PostsDetailsContractor.CommentsView view) {
        this.mCommentsView = view;//attaching comments view
    }

    @Override
    public void detachView() {
        mCommentsView = null;//detaching comments view

    }

    @Override
    public void loadComments(int postId) {
        mCommentsRepository.getComments(new CommentsRepository.LoadCommentsCallBack() {
            @Override
            public void onCommentsLoaded(List<Comment> comments) {
                mCommentsView.showComments(comments);//loading comments on UI
            }
        },postId);
    }


}