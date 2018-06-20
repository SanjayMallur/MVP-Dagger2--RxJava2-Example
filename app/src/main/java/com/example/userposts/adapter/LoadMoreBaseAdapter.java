package com.example.userposts.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.userposts.R;

import java.util.List;

/**
 * Base adapter to handler adapter view and progress dialog which extents RecyclerView adapter
 *
 * @author Sanjay Mallur
 */
abstract class LoadMoreBaseAdapter<T, viewHolder extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    protected static final int VIEW_TYPE_LOAD = 1;//view type is loading progress bar
    protected static final int VIEW_TYPE_DATA = 2;//view type is loading adapter view

    private boolean hasLoadingFooter;// boolean to check footer progress bar

    protected List<T> data;//List data from activity or fragment

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //checking view type
        if (viewType == VIEW_TYPE_LOAD) {
            View progressView = LayoutInflater.from(parent.getContext()).inflate(R.layout.progress_bar_item, parent, false);
            return new ProgressViewHolder(progressView);
        } else {
            return onCreateDataViewHolder(parent, viewType);
        }
    }

    public abstract RecyclerView.ViewHolder onCreateDataViewHolder(ViewGroup parent, int viewType);

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == VIEW_TYPE_LOAD) {//checking itemViewType to load respective view
            onBindProgressView(holder, position);//Loading progress view
        } else {
            onBindDataViewHolder(holder, position);//Loading adapter view
        }
    }

    /**
     * Abstract method to set the data on UI
     */
    public abstract void onBindDataViewHolder(RecyclerView.ViewHolder holder, int position);

    /**
     * Progress bar view to show when loading items
     */
    protected void onBindProgressView(RecyclerView.ViewHolder holder, int position) {
        ((ProgressViewHolder) holder).progressBar.setIndeterminate(true);
    }

    @Override
    public int getItemViewType(int position) {
        return data.get(position) != null ? VIEW_TYPE_DATA : VIEW_TYPE_LOAD;//Checking item position to load respective view
    }

    @Override
    public int getItemCount() {
        return data.size();//Data size to return
    }

    /**
     * Progress view holder which extends RecyclerViewHolder
     */
    public static class ProgressViewHolder extends RecyclerView.ViewHolder {
        private ProgressBar progressBar;

        public ProgressViewHolder(View v) {
            super(v);
            progressBar = (ProgressBar) v.findViewById(R.id.progressBar);//progress bar to show when loading items
        }
    }

    /**
     * Method to get the item in with postion
     *
     * @param index item position
     */
    public T getItem(int index) {
        if (data != null && data.get(index) != null) {
            return data.get(index);
        } else {
            throw new IllegalArgumentException("Item with index " + index + " doesn't exist, dataSet is " + data);
        }
    }

    /**
     * Check for loading progress bar
     */
    public boolean isLoading() {
        return hasLoadingFooter;
    }

    /**
     * Method to set progress bar as true at the footer
     * @param loading setting true or false
     */
    public void setLoading(boolean loading) {
        if (loading) {
            hasLoadingFooter = true;
            data.add(null);
            notifyItemInserted(data.size() - 1);//notifying item inserted at with position

        } else {
            hasLoadingFooter = false;
            notifyItemRemoved(data.size() - 1);//notifying item removed at position
        }
        notifyDataSetChanged();//notifying adapter for changer done
    }
}
