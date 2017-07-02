package com.holidaypirates.userposts.presenter;

import android.support.annotation.NonNull;

import com.holidaypirates.userposts.data.PostRepository;
import com.holidaypirates.userposts.model.Post;
import com.holidaypirates.userposts.ui.posts.PostsContractor;

import java.util.List;

/**
 * {@link PostsMvpPresenter -- to show posts data on UI after attaching view}
 * @author Sanjay Mallur
 */
public class PostsMvpPresenter implements PostsContractor.PostsMvpPresenter<PostsContractor.PostsViewApp> {

    private PostsContractor.PostsViewApp mPostsView;//Posts view
    private PostRepository mPostsRepository;//Posts repository
    /**
     * Constructor called from posts fragment to inject service request
     * @param postRepository repository to get the data callback
     */
    public PostsMvpPresenter(@NonNull PostRepository postRepository){
        mPostsRepository = postRepository;
    }

    @Override
    public void loadPosts(boolean loadMore, boolean forceUpdate) {
        mPostsView.showPostsLoading(true);
        mPostsRepository.getPosts(new PostRepository.LoadPostsCallback() {
            @Override
            public void onPostsLoaded(List<Post> posts) {
                mPostsView.showPostsLoading(false);
                mPostsView.showPosts(posts);//show posts on UI
            }
        }, loadMore, forceUpdate);
    }

    @Override
    public void openPostDetails(@NonNull Post postClicked) {
        //Some validations
        mPostsView.showPostDetailUi(postClicked);
    }

    @Override
    public void attachView(PostsContractor.PostsViewApp mPostsView) {
        this.mPostsView = mPostsView;
    }

    @Override
    public void detachView() {
        mPostsView = null;
    }

}
