package com.holidaypirates.userposts.ui.postdetail;

import com.holidaypirates.userposts.model.Comment;
import com.holidaypirates.userposts.model.Photos;
import com.holidaypirates.userposts.model.User;
import com.holidaypirates.userposts.ui.common.AppMvpPresenter;
import com.holidaypirates.userposts.ui.common.AppMvpView;

import java.util.List;

/**
 * {@link PostsDetailsContractor -- Interface to have communicationa between all presenters and views of post details}
 * @author Sanjay Mallur
 */

public interface PostsDetailsContractor {

     interface PhotoPresenter<v> extends AppMvpPresenter<v> {
        void loadPhotos();
    }

    interface UserPresenter<v> extends AppMvpPresenter<v> {
        void loadUsers();
    }

    interface CommentPresenter<v> extends AppMvpPresenter<v> {
         void loadComments(int postId);

    }
    interface PhotosView extends AppMvpView {
         void showPhotos(List<Photos> photos);
    }

    interface UsersView extends AppMvpView {
        void showUsers(List<User> users);
    }

    interface CommentsView extends AppMvpView {
         void showComments(List<Comment> comments);
    }

}
