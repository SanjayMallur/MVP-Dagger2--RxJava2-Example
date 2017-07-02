package com.holidaypirates.userposts.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.holidaypirates.userposts.R;
import com.holidaypirates.userposts.model.Photos;

import java.util.List;

/**
 * {@link PhotosAdapter --  Adapter to have ui to show details of photos}
 * @author Sanjay mallur
 */

public class PhotosAdapter extends LoadMoreBaseAdapter<Photos, PhotosAdapter.PhotosViewHolder> {

    private Context mContext;
    /**
     * Public constructor to set data to list
     * @param photos List data from fragment
     * */
    public PhotosAdapter(List<Photos> photos) {
        setPhotosList(photos);
    }

    @Override
    public RecyclerView.ViewHolder onCreateDataViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View photosView = inflater.inflate(R.layout.gallery_thumbnail, parent, false);
        return new PhotosViewHolder(photosView);
    }

    @Override
    public void onBindDataViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == VIEW_TYPE_DATA) {
            bindPhotosViewHolder((PhotosViewHolder) holder, position);
        }


    }
    /**
     * Setting list data to base data object
     *
     * @param photos comments list
     */
    private void setPhotosList(List<Photos> photos) {
        this.data = photos;
    }
    /**
     * ViewHolder extending {@link RecyclerView.ViewHolder}
     */
    public class PhotosViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageThumbNail;
        public PhotosViewHolder(View itemView) {
            super(itemView);
            imageThumbNail = (ImageView) itemView.findViewById(R.id.thumbnail);
        }
    }

    /**
     * bindCommentsViewHolder--to set the photos data to UI with  help of Glide to handle photos efficiently
     * @param photosViewHolder base view holder
     * @param position item position
     */
    private void bindPhotosViewHolder(PhotosViewHolder photosViewHolder, int position) {
        Photos photo = data.get(position);//getting data for position
        Glide.with(mContext).load(photo.getUrl())
                .thumbnail(0.5f)
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(photosViewHolder.imageThumbNail);
    }
    /**
     * Method to replace data and notifying adapter that data has changed
     *
     * @param photos List data from fragment
     */
    public void replaceData(List<Photos> photos) {
        setPhotosList(photos);
        notifyDataSetChanged();
    }

}
