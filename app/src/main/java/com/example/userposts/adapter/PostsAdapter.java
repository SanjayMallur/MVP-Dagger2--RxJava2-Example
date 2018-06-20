package com.example.userposts.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.userposts.R;
import com.example.userposts.model.Post;

import java.util.List;

/**
 * {@link PostsAdapter -- Adapter to have ui to show details of posts}
 * @author Sanjay mallur
 */

public class PostsAdapter extends LoadMoreBaseAdapter<Post, PostsAdapter.PostViewHolder> {

    private PostItemListener mItemListener;//Posts each item click listener

    /**
     * Public constructor to set data to list
     * @param posts List data from fragment
     * @param itemListener item listener
     * */
    public PostsAdapter(List<Post> posts, PostItemListener itemListener) {
        setList(posts);
        mItemListener = itemListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateDataViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View postView = inflater.inflate(R.layout.list_posts, parent, false);
        return new PostViewHolder(postView, mItemListener);
    }

    @Override
    public void onBindDataViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == VIEW_TYPE_DATA) {
            bindPostViewHolder((PostViewHolder)holder, position);
        }
    }
    /**
     * bindPostViewHolder--to set the photos data to UI
     * @param postViewHolder base view holder
     * @param position item position
     */
    private void bindPostViewHolder(PostViewHolder postViewHolder, int position) {
        Post post = data.get(position);//getting data per position
        postViewHolder.postTitle.setText(String.valueOf(post.getTitle()));
        postViewHolder.postIdTextView.setText(String.valueOf(post.getId()));
        postViewHolder.titleTextView.setText(post.getBody());
    }
    /**
     * Method to replace data and notifying adapter that data has changed
     *
     * @param posts List data from fragment
     */
    public void replaceData(List<Post> posts) {
        data.clear();
        setList(posts);
        notifyDataSetChanged();
    }
    /**
     * Setting list data to base data object
     *
     * @param posts comments list
     */
    private void setList(List<Post> posts) {
        this.data = posts;
    }
    /**
     * ViewHolder extending {@link RecyclerView.ViewHolder}
     */
    public class PostViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView postTitle;
        private TextView postIdTextView;
        private TextView titleTextView;

        private PostItemListener mItemListener;

        public PostViewHolder(View itemView, PostItemListener listener) {
            super(itemView);
            mItemListener = listener;
            postIdTextView = (TextView) itemView.findViewById(R.id.postIdTextView);
            postTitle = (TextView) itemView.findViewById(R.id.userIdTextView);
            titleTextView = (TextView) itemView.findViewById(R.id.titleTextView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            Post post = getItem(position);
            mItemListener.onPostClick(post);//getting data from listener click
        }
    }
    @FunctionalInterface
    public interface PostItemListener {
        void onPostClick(Post clickedPost);

    }

}
