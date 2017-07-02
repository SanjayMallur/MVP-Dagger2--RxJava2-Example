package com.holidaypirates.userposts;

import com.holidaypirates.userposts.data.PostRepository;
import com.holidaypirates.userposts.networking.services.PostServiceAPIImp;
import com.holidaypirates.userposts.util.API;

/**
 * Class to show online and offline data to user when there is state change in network connection
 * @author Sanjay Mallur
 */
public class Injection {

    public static PostRepository providePostsRepository() {
        return MainRepositories.getPostManager(API.isConnected() ? new PostServiceAPIImp() : new MockPostServiceAPIImp());
    }

}