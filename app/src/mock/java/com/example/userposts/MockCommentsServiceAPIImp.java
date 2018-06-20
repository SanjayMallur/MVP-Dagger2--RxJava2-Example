package com.example.userposts;

import com.example.userposts.model.Comment;
import com.example.userposts.networking.services.CommentsServiceAPI;

import java.util.ArrayList;
import java.util.List;

/**
 * Class to show mock comment data on UI
 * @author Sanjay mallur
 */

public class MockCommentsServiceAPIImp implements CommentsServiceAPI {
    @Override
    public void getComments(CommentsServiceCallBack<List<Comment>> commentsCallBack,int postId) {
        List<Comment> mCommentsList=new ArrayList<>();
        Comment mComment=new Comment();
        mComment.setBody("Nice photos");
        mComment.setEmail("sanjaymallur@gmail.com");
        mComment.setName("Sanjay");
        mComment.setPostId(postId);
        mComment.setId("10");
        mCommentsList.add(mComment);
        commentsCallBack.onCommentsLoaded(mCommentsList);
    }
}
