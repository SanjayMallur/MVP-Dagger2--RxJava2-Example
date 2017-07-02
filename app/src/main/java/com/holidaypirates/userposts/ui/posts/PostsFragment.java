package com.holidaypirates.userposts.ui.posts;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.holidaypirates.userposts.Injection;
import com.holidaypirates.userposts.R;
import com.holidaypirates.userposts.adapter.PostsAdapter;
import com.holidaypirates.userposts.model.Post;
import com.holidaypirates.userposts.presenter.PostsMvpPresenter;
import com.holidaypirates.userposts.ui.BaseFragment;
import com.holidaypirates.userposts.ui.custom.EndlessRecyclerOnScrollListener;
import com.holidaypirates.userposts.ui.postdetail.PostDetailActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * {@link PostsFragment -- Place holder fragment containg simple view and calling API to get posts and set adapter to show data on UI after attaching view}
 * @author Sanjay Mallur
 */
public class PostsFragment extends BaseFragment<PostsContractor.PostsMvpPresenter> implements PostsContractor.PostsViewApp, PostsAdapter.PostItemListener {

    private RecyclerView rvPosts;
    private SwipeRefreshLayout swlMain;
    private PostsAdapter mPostAdapter;
    private EndlessRecyclerOnScrollListener mEndlessRecyclerOnScrollListener;
    private  SharedPreferences sharedpreferences;;
    public static final String MyPREFERENCES = "AppPref" ;

    public static PostsFragment newInstance() {
        return new PostsFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        sharedpreferences = getActivity().getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        rvPosts = (RecyclerView)rootView.findViewById(R.id.recyclerView);
        swlMain = (SwipeRefreshLayout)rootView.findViewById(R.id.srl_main);
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        rvPosts.setHasFixedSize(true);
        rvPosts.setLayoutManager(linearLayoutManager);
        mEndlessRecyclerOnScrollListener = new EndlessRecyclerOnScrollListener(linearLayoutManager) {
            @Override
            public void onLoadMore(int currentPage) {
                if (!mPostAdapter.isLoading()) {
                    mPresenter.loadPosts(true, false);//load more called
                }
            }
        };
        rvPosts.addOnScrollListener(mEndlessRecyclerOnScrollListener);
        swlMain.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mEndlessRecyclerOnScrollListener.reset();
                mPresenter.loadPosts(false, true);//load more is not called
            }
        });
        return rootView;
    }

    @Override
    public void showPostsLoading(boolean loading) {
       if (mPostAdapter != null)
           mPostAdapter.setLoading(loading);//setting progress indicator
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.loadPosts(false, false);//telling presenter to load comments
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        mPresenter = new PostsMvpPresenter(Injection.providePostsRepository());
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void showPosts(List<Post> posts) {
        swlMain.setRefreshing(false);
        if (mPostAdapter == null) {
            mPostAdapter = new PostsAdapter(new ArrayList<>(posts), this);
            rvPosts.setAdapter(mPostAdapter);//Setting adapter
        }
        mPostAdapter.replaceData(new ArrayList<>(posts));//notifyData set changed
    }

    @Override
    public void showPostDetailUi(Post post) {
        Intent intent = new Intent(getActivity(), PostDetailActivity.class);//PostDetailActivity intent
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString("postId", post.getId());
        editor.commit();
        startActivity(intent);
    }

    @Override
    public void onPostClick(Post clickedPost) {
        mPresenter.openPostDetails(clickedPost);
    }

}
