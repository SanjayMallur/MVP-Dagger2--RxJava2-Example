package com.example.userposts.data;

import android.support.annotation.NonNull;

import com.example.userposts.model.User;
import com.example.userposts.networking.services.UsersServiceAPI;

import java.util.ArrayList;
import java.util.List;

/**
 * {@link UsersManager --To get the users from service API and adding to list}
 *
 * @author Sanjay Mallur
 */

public class UsersManager implements UsersRepository{
    private List<User> mUsers=new ArrayList<>();
    private UsersServiceAPI mUserServiceAPI;
    /**
     * Constructor called From Repositories
     *
     * @param usersServiceAPI interface
     */
    public UsersManager(@NonNull UsersServiceAPI usersServiceAPI){
        this.mUserServiceAPI=usersServiceAPI;
    }

    @Override
    public void getUsers(@NonNull final LoadUsersCallBack usersCallBack) {
        mUsers.clear();
        mUserServiceAPI.getUsers(new UsersServiceAPI.UsersServiceCallBack<List<User>>() {
            @Override
            public void onUsersLoaded(List<User> users) {
                mUsers.addAll(new ArrayList<>(users));//adding data to array list
                usersCallBack.onUsersLoaded(mUsers);//passing list data to repository
            }
        });

    }
}
