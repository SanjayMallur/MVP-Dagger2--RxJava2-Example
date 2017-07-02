package com.holidaypirates.userposts;

import com.holidaypirates.userposts.data.PostRepository;
import com.holidaypirates.userposts.model.Post;
import com.holidaypirates.userposts.ui.posts.PostsContractor;
import com.holidaypirates.userposts.presenter.PostsMvpPresenter;

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
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class PostsUnitTest {

    @Mock
    private PostRepository mPostRepository;

    @Mock
    private PostsContractor.PostsViewApp mPostsView;

    @Captor
    private ArgumentCaptor<PostRepository.LoadPostsCallback> mLoadPostsCallbackCaptor;

    private PostsMvpPresenter mPostsPresenter;

    private static List<Post> mPostList = new ArrayList<>();

    @Before
    public void setupPostsPresenter() {
        MockitoAnnotations.initMocks(this);
        mPostsPresenter = new PostsMvpPresenter(mPostRepository);
        mPostsPresenter.attachView(mPostsView);
        Post mPost=new Post();
        mPost.setTitle("Post1");
        mPost.setBody("Hello pirates");
        mPost.setId("1");
        mPost.setUserId(10);
        mPostList.add(mPost);
        mPostList.add(mPost);

    }

    @Test
    public void loadPostsFromRepositoryAndLoadIntoView() {
        mPostsPresenter.loadPosts(true, false);

        verify(mPostRepository).getPosts(mLoadPostsCallbackCaptor.capture(), eq(true), eq(false));
        mLoadPostsCallbackCaptor.getValue().onPostsLoaded(mPostList);

        verify(mPostsView).showPostsLoading(false);
        verify(mPostsView).showPosts(mPostList);
        Assert.assertEquals(mPostList.get(0).getId(),"1");
        Assert.assertEquals(mPostList.get(0).getUserId(),10);
        Assert.assertEquals(mPostList.get(0).getBody(),"Hello pirates");
        Assert.assertEquals(mPostList.get(0).getTitle(),"Post1");

    }
}