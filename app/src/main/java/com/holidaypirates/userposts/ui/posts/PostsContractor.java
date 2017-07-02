package com.holidaypirates.userposts.ui.posts;

import android.support.annotation.NonNull;

import com.holidaypirates.userposts.model.Post;
import com.holidaypirates.userposts.ui.common.AppMvpView;
import com.holidaypirates.userposts.ui.common.AppMvpPresenter;

import java.util.List;

/**
 * {@link PostsContractor -- Interface to have communicationa between post presenters and post vies}
 * @author Sanjay Mallur
 */
public interface PostsContractor {

    interface PostsMvpPresenter<View> extends AppMvpPresenter<View> {

        void loadPosts(boolean loadMore, boolean forceUpdate);

        void openPostDetails(@NonNull Post postClicked);

    }

    interface PostsViewApp extends AppMvpView {

        void showPosts(List<Post> posts);

        void showPostsLoading(boolean loading);

        void showPostDetailUi(Post post);

    }

}
