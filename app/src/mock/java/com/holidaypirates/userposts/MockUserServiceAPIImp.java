package com.holidaypirates.userposts;

import com.holidaypirates.userposts.model.User;
import com.holidaypirates.userposts.networking.services.UsersServiceAPI;

import java.util.ArrayList;
import java.util.List;

/**
 *Class to show mock user data on UI
 * @author Sanjay mallur
 */

public class MockUserServiceAPIImp implements UsersServiceAPI {

    @Override
    public void getUsers(UsersServiceCallBack<List<User>> usersCallBack) {
        List<User> usersList=new ArrayList<>();
        User user=new User();
        user.setPhone("+919886573173");
        user.setWebsite("www.aboutme.com/sanjaymallur");
        user.setEmail("sanjaymallur@gmail.com");
        user.setName("Sanjay");
        user.setUsername("sanjaymallur");
        usersList.add(user);
        usersCallBack.onUsersLoaded(usersList);
    }
}
