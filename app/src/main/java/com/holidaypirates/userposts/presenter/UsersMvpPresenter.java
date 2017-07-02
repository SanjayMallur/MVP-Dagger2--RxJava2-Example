package com.holidaypirates.userposts.presenter;

import android.support.annotation.NonNull;

import com.holidaypirates.userposts.data.UsersRepository;
import com.holidaypirates.userposts.model.User;
import com.holidaypirates.userposts.ui.postdetail.PostsDetailsContractor;

import java.util.List;

/**
 * {@link UsersMvpPresenter -- to show posts data on UI after attaching view}
 * @author Sanjay Mallur
 */

public class UsersMvpPresenter implements PostsDetailsContractor.UsersMvpPresenter<PostsDetailsContractor.UsersView> {

    private PostsDetailsContractor.UsersView mUsersView;//users view
    private UsersRepository mUsersRepository;//users repository
    /**
     * Constructor called from posts fragment to inject service request
     * @param usersRepository repository to get the data callback
     */
    public UsersMvpPresenter(@NonNull UsersRepository usersRepository){
        mUsersRepository= usersRepository;
    }


    @Override
    public void attachView(PostsDetailsContractor.UsersView view) {
        this.mUsersView=view;
    }

    @Override
    public void detachView() {
        mUsersRepository=null;

    }

    @Override
    public void loadUsers() {
        mUsersRepository.getUsers(new UsersRepository.LoadUsersCallBack() {
            @Override
            public void onUsersLoaded(List<User> users) {
                mUsersView.showUsers(users);//show users on UI
            }
        });
    }
}

