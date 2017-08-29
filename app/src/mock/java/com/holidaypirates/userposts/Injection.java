package com.holidaypirates.userposts;

import com.holidaypirates.userposts.data.CommentsRepository;
import com.holidaypirates.userposts.data.MainRepositories;
import com.holidaypirates.userposts.data.PhotosRepository;
import com.holidaypirates.userposts.data.PostRepository;
import com.holidaypirates.userposts.data.UsersRepository;

/**
 * Class to inject whether online or offline mocked data
 * @author Sanjay Mallur
 */
public class Injection {

   public static PostRepository providePostsRepository() {
      return MainRepositories.getPostManager(new MockPostServiceAPIImp());
   }
   public static PhotosRepository providePhotosRepository(){
      return MainRepositories.getPostsDetailManager(new MockPhotosServiceAPIImp());
   }
   public static UsersRepository provideUsersRepository(){
      return MainRepositories.getUsersManager(new MockUserServiceAPIImp());
   }
   public static CommentsRepository provideCommentsRepository(){
      return MainRepositories.getCommentsManager(new MockCommentsServiceAPIImp());
   }

}
