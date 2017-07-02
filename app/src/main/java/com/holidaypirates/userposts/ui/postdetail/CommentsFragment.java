package com.holidaypirates.userposts.ui.postdetail;

import android.content.Context;
import android.content.SharedPreferences;
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
import com.holidaypirates.userposts.adapter.CommentsAdapter;
import com.holidaypirates.userposts.model.Comment;
import com.holidaypirates.userposts.presenter.CommentsMvpPresenter;
import com.holidaypirates.userposts.ui.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import static com.holidaypirates.userposts.ui.posts.PostsFragment.MyPREFERENCES;

/**
 * {@link CommentsFragment -- Comments fragment to call API to get comments and set adapter to show data on UI after attaching view}
 * @author Sanjay Mallur
 */

public class CommentsFragment extends BaseFragment<PostsDetailsContractor.CommentsMvpPresenter> implements PostsDetailsContractor.CommentsView {

    private RecyclerView commentsRecyclerView;//Recycler view to show comments list
    private CommentsAdapter mCommentsAdapter;//Adapter to handle provided data
    private SharedPreferences sharedpreferences;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            String myInt = bundle.getString("id");
        }
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_comments_detail, container, false);
        commentsRecyclerView=(RecyclerView)rootView.findViewById(R.id.comments_list);
        LinearLayoutManager usersLinearManager = new LinearLayoutManager(getActivity());
        sharedpreferences = getActivity().getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        commentsRecyclerView.setLayoutManager(usersLinearManager);
        commentsRecyclerView.setItemAnimator(new DefaultItemAnimator());

        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        String postId=sharedpreferences.getString("postId","postId");
        mPresenter.loadComments(postId);//telling presenter to load comments
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        mPresenter=new CommentsMvpPresenter(Injection.provideCommentsRepository());
        super.onViewCreated(view, savedInstanceState);
    }


    @Override
    public void showComments(List<Comment> comments) {
        if(mCommentsAdapter==null){
            mCommentsAdapter=new CommentsAdapter(new ArrayList<>(comments));
            commentsRecyclerView.setAdapter(mCommentsAdapter);//Setting adapter to recycler view
        }
        mCommentsAdapter.replaceData(comments);//notifying data changed

    }

}
