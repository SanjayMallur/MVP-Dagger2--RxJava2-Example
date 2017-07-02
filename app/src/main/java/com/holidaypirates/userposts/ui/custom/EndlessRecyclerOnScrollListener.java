package com.holidaypirates.userposts.ui.custom;


import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * Recycler view scroll listener
 * @author Sanjay Mallur

 */
public abstract class EndlessRecyclerOnScrollListener extends RecyclerView.OnScrollListener {

    private int previousTotal = 0; // The total number of items in the dataset after the last load
    private boolean loading = true; // True if we are still waiting for the last set of data to load.
    private int visibleThreshold = 2; // The minimum amount of items to have below your current scroll position before loading more.
    int firstVisibleItem;
    int visibleItemCount;
    int totalItemCount;

    private int current_page = 1;//setting current page as 1

    private LinearLayoutManager mLinearLayoutManager;

    public EndlessRecyclerOnScrollListener(LinearLayoutManager linearLayoutManager) {
        this.mLinearLayoutManager = linearLayoutManager;
    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);

        visibleItemCount = mLinearLayoutManager.getChildCount();
        totalItemCount = mLinearLayoutManager.getItemCount();
        firstVisibleItem = mLinearLayoutManager.findFirstVisibleItemPosition();
        if (loading && (totalItemCount > previousTotal)) {
                loading = false;
                previousTotal = totalItemCount;
        }
        if (!loading && (totalItemCount - visibleItemCount)
                <= (firstVisibleItem + visibleThreshold)) {
            // End has been reached
            // Do something
            current_page++;
            onLoadMore(current_page);
            loading = true;
        }
    }
/**
* to reset page count
* */
    public void reset() {
        previousTotal = 0;
        current_page = 1;
        loading = true;
    }

    public abstract void onLoadMore(int currentPage);//providing load more callback
}