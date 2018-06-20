package com.example.userposts.networking.services;

import com.example.userposts.model.User;

import java.util.List;

/**
 * {@link UsersServiceAPI --Interface to get the users data from API}.
 * @author Sanjay Mallur
 */
@FunctionalInterface
public interface UsersServiceAPI {
    @FunctionalInterface
    interface UsersServiceCallBack<T>{
        void onUsersLoaded(T users);
    }
    void getUsers(UsersServiceCallBack<List<User>> usersCallBack);
}
