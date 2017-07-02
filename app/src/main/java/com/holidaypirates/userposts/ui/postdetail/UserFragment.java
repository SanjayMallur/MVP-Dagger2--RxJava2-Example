package com.holidaypirates.userposts.ui.postdetail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.holidaypirates.userposts.Injection;
import com.holidaypirates.userposts.R;
import com.holidaypirates.userposts.adapter.UsersAdapter;
import com.holidaypirates.userposts.model.User;
import com.holidaypirates.userposts.presenter.UserPresenter;
import com.holidaypirates.userposts.ui.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * {@link UserFragment -- Place holder fragment containg simple view and calling API to get users and set adapter to show data on UI after attaching view}
 * @author Sanjay Mallur
 */

public class UserFragment extends BaseFragment<PostsDetailsContractor.UserPresenter> implements PostsDetailsContractor.UsersView {


    private RecyclerView usersRecyclerView;
    private UsersAdapter mUsersAdapter;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_users_detail, container, false);
        usersRecyclerView=(RecyclerView)rootView.findViewById(R.id.users_list);

        LinearLayoutManager usersLinearManager = new LinearLayoutManager(getActivity());
        usersRecyclerView.setLayoutManager(usersLinearManager);
        usersRecyclerView.setItemAnimator(new DefaultItemAnimator());
        return rootView;
    }


    @Override
    public void onResume() {
        super.onResume();
        mPresenter.loadUsers();//telling presenter to load users
    }



    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        mPresenter=new UserPresenter(Injection.provideUsersRepository());
        super.onViewCreated(view, savedInstanceState);
    }


    @Override
    public void showUsers(List<User> users) {
        if (mUsersAdapter == null) {
            mUsersAdapter=new UsersAdapter(new ArrayList<>(users));
            usersRecyclerView.setAdapter(mUsersAdapter);
        }
        mUsersAdapter.replaceData(users);

    }
}

