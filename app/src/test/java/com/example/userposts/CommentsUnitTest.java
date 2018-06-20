package com.example.userposts;

import com.example.userposts.data.CommentsRepository;
import com.example.userposts.model.Comment;
import com.example.userposts.presenter.CommentPresenter;
import com.example.userposts.ui.postdetail.PostsDetailsContractor;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;

/**
 * Created by Sanjay on 01-07-2017.
 */

public class CommentsUnitTest {
    @Mock
    private CommentsRepository mCommentsRepository;

    @Mock
    private PostsDetailsContractor.CommentsView mCommentsView;

    @Captor
    ArgumentCaptor<CommentsRepository.LoadCommentsCallBack> mLoadCommentsCallBackCaptor;

    private CommentPresenter mCommentsPresenter;

    private static List<Comment> mCommentsList=new ArrayList<>();
    int postId=1;

    @Before
    public void setupCommentsPresenter(){
        MockitoAnnotations.initMocks(this);
        mCommentsPresenter=new CommentPresenter(mCommentsRepository);
        mCommentsPresenter.attachView(mCommentsView);
        Comment mComment=new Comment();
        mComment.setEmail("sanjaymallur@gmail.com");
        mComment.setName("Sanjay");
        mComment.setId("10");
        mComment.setPostId(postId);
        mComment.setBody("Very nice and good capture");
        mCommentsList.add(mComment);

    }

    @Test
    public void loadCommentsFromRepositoryAndLoadToView(){
        mCommentsPresenter.loadComments(postId);

        verify(mCommentsRepository).getComments(mLoadCommentsCallBackCaptor.capture(),eq(postId));
        mLoadCommentsCallBackCaptor.getValue().onCommentsLoaded(mCommentsList);

        verify(mCommentsView).showComments(mCommentsList);
        Assert.assertEquals(mCommentsList.get(0).getId(),"10");
        Assert.assertEquals(mCommentsList.get(0).getBody(),"Very nice and good capture");
        Assert.assertEquals(mCommentsList.get(0).getEmail(),"sanjaymallur@gmail.com");
        Assert.assertEquals(mCommentsList.get(0).getName(),"Sanjay");
        Assert.assertEquals(mCommentsList.get(0).getPostId(),postId);
    }






}

