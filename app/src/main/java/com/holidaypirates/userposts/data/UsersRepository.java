package com.holidaypirates.userposts.data;

import android.support.annotation.NonNull;

import com.holidaypirates.userposts.model.User;

import java.util.List;

/**
 * Interface to get callback in Users manager to load data
 * @author Sanjay Mallur
 * {@link UsersRepository}
 */
@FunctionalInterface
public interface UsersRepository {
    @FunctionalInterface
    interface LoadUsersCallBack{
        void onUsersLoaded(List<User> users);
    }
    void getUsers(@NonNull LoadUsersCallBack usersCallBack);
}
