package com.example.userposts.module;

import com.example.userposts.networking.services.CommentsServiceAPIImp;
import com.example.userposts.networking.services.PhotosServiceAPIImp;
import com.example.userposts.networking.services.PostServiceAPIImp;
import com.example.userposts.networking.services.UsersServiceAPIImp;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @author Sanjay Mallur
 * {@link NetComponent - Singleton NetComponent interface}
 */
@Singleton
@Component(modules = {AppModule.class, NetModule.class})
public interface NetComponent {
    void inject(PostServiceAPIImp postServiceAPIImp);
    void inject(UsersServiceAPIImp usersServiceAPIImp);
    void inject(PhotosServiceAPIImp photosServiceAPIImp);
    void inject(CommentsServiceAPIImp commentsServiceAPIImp);
}
