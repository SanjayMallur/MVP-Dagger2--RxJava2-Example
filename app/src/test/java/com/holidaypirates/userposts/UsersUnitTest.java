package com.holidaypirates.userposts;

import com.holidaypirates.userposts.data.UsersRepository;
import com.holidaypirates.userposts.model.User;
import com.holidaypirates.userposts.ui.postdetail.PostsDetailsContractor;
import com.holidaypirates.userposts.presenter.UserPresenter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;

/**
 * Created by Sanjay on 01-07-2017.
 */

public class UsersUnitTest {

    @Mock
    private UsersRepository mUsersRepository;

    @Mock
    private PostsDetailsContractor.UsersView mUsersView;

    @Captor
    ArgumentCaptor<UsersRepository.LoadUsersCallBack> mLoadUsersCallBackCaptor;

    private UserPresenter mUsersPresenter;

    private static List<User> mUsersList=new ArrayList<>();

    @Before
    public void setupPhotosPresenter(){
        MockitoAnnotations.initMocks(this);
        mUsersPresenter=new UserPresenter(mUsersRepository);
        mUsersPresenter.attachView(mUsersView);
        User user=new User();
        user.setId(1);
        user.setUsername("sanjay");
        user.setName("Sanjay Mallur");
        user.setEmail("sanjaymallur@gmail.com");
        user.setPhone("+919886573173");
        user.setWebsite("www.aboutme.com/sanjaymallur");
        mUsersList.add(user);
    }

    @Test
    public void loadUsersFromRepositoryAndLoadToView(){
        mUsersPresenter.loadUsers();
        verify(mUsersRepository).getUsers(mLoadUsersCallBackCaptor.capture());
        mLoadUsersCallBackCaptor.getValue().onUsersLoaded(mUsersList);
        verify(mUsersView).showUsers(mUsersList);
        Assert.assertEquals(mUsersList.get(0).getUsername(),"sanjay");
        Assert.assertEquals(mUsersList.get(0).getName(),"Sanjay Mallur");
        Assert.assertEquals(mUsersList.get(0).getId(),1);
        Assert.assertEquals(mUsersList.get(0).getPhone(),"+919886573173");
        Assert.assertEquals(mUsersList.get(0).getWebsite(),"www.aboutme.com/sanjaymallur");
        Assert.assertEquals(mUsersList.get(0).getEmail(),"sanjaymallur@gmail.com");
    }
}
