package com.holidaypirates.userposts.networking.services;

import com.holidaypirates.userposts.model.User;

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
