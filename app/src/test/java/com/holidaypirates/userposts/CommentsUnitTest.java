package com.holidaypirates.userposts;

import com.holidaypirates.userposts.data.CommentsRepository;
import com.holidaypirates.userposts.model.Comment;
import com.holidaypirates.userposts.presenter.CommentsMvpPresenter;
import com.holidaypirates.userposts.ui.postdetail.PostsDetailsContractor;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

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

    private CommentsMvpPresenter mCommentsPresenter;

    private static List<Comment> mCommentsList=new ArrayList<>();

    @Before
    public void setupCommentsPresenter(){
        MockitoAnnotations.initMocks(this);
        mCommentsPresenter=new CommentsMvpPresenter(mCommentsRepository);
        mCommentsPresenter.attachView(mCommentsView);
        Comment mComment=new Comment();
        mComment.setEmail("sanjaymallur@gmail.com");
        mComment.setName("Sanjay");
        mComment.setId("10");
        mComment.setPostId(1);
        mComment.setBody("Very nice and good capture");
        mCommentsList.add(mComment);

    }

    @Test
    public void loadCommentsFromRepositoryAndLoadToView(){
        mCommentsPresenter.loadComments();

        verify(mCommentsRepository).getComments(mLoadCommentsCallBackCaptor.capture());
        mLoadCommentsCallBackCaptor.getValue().onCommentsLoaded(mCommentsList);

        verify(mCommentsView).showComments(mCommentsList);
        Assert.assertEquals(mCommentsList.get(0).getId(),"10");
        Assert.assertEquals(mCommentsList.get(0).getPostId(),1);
        Assert.assertEquals(mCommentsList.get(0).getBody(),"Very nice and good capture");
        Assert.assertEquals(mCommentsList.get(0).getEmail(),"sanjaymallur@gmail.com");
        Assert.assertEquals(mCommentsList.get(0).getName(),"Sanjay");
    }






}

