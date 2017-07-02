package com.holidaypirates.userposts;

import com.holidaypirates.userposts.model.Comment;
import com.holidaypirates.userposts.networking.services.CommentsServiceAPI;

import java.util.ArrayList;
import java.util.List;

/**
 * Class to show mock comment data on UI
 * @author Sanjay mallur
 */

public class MockCommentsServiceAPIImp implements CommentsServiceAPI {
    String postId="1";
    @Override
    public void getComments(CommentsServiceCallBack<List<Comment>> commentsCallBack,String postId) {
        List<Comment> mCommentsList=new ArrayList<>();
        Comment mComment=new Comment();
        mComment.setBody("Nice photos");
        mComment.setEmail("sanjaymallur@gmail.com");
        mComment.setName("Sanjay");
        mComment.setPostId(1);
        mComment.setId("10");
        mCommentsList.add(mComment);
        commentsCallBack.onCommentsLoaded(mCommentsList);
    }
}
