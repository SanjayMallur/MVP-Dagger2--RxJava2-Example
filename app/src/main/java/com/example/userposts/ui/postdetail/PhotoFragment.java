package com.example.userposts.ui.postdetail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.userposts.Injection;
import com.example.userposts.R;
import com.example.userposts.adapter.PhotosAdapter;
import com.example.userposts.model.Photos;
import com.example.userposts.presenter.PhotoPresenter;
import com.example.userposts.ui.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * {@link PhotoFragment -- Place holder fragment containg simple view and calling API to get photos and set adapter to show data on UI after attaching view}
 * @author Sanjay Mallur
 */
public class PhotoFragment extends BaseFragment<PostsDetailsContractor.PhotoPresenter> implements PostsDetailsContractor.PhotosView {

    private RecyclerView photosRecyclerView;//simple recycler view
    private PhotosAdapter mPhotosAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_photos_detail, container, false);
        photosRecyclerView = (RecyclerView)rootView.findViewById(R.id.photos_list);
         RecyclerView.LayoutManager photosGridManager = new GridLayoutManager(getActivity(), 2);//setting layout as grid for photos
        photosRecyclerView.setLayoutManager(photosGridManager);
        photosRecyclerView.setItemAnimator(new DefaultItemAnimator());
        return rootView;
    }


    @Override
    public void onResume() {
        super.onResume();
        mPresenter.loadPhotos();//telling presenter to load photos

    }



    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        mPresenter = new PhotoPresenter(Injection.providePhotosRepository());
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void showPhotos(List<Photos> photos) {
        if (mPhotosAdapter == null) {
            mPhotosAdapter = new PhotosAdapter(new ArrayList<>(photos));//
            photosRecyclerView.setAdapter(mPhotosAdapter);//setting adapter to recycler view
        }
        mPhotosAdapter.replaceData(new ArrayList<>(photos));//notifying adapter that change in data

    }
}
