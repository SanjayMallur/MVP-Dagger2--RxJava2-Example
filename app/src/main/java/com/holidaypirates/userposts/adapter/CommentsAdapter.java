package com.holidaypirates.userposts.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.holidaypirates.userposts.R;
import com.holidaypirates.userposts.model.Comment;

import java.util.List;

/**
 *
 * {@link CommentsAdapter -- Adapter to have ui to show details of comments from user}
 * @author Sanjay Mallur
 *
 */

public class CommentsAdapter extends LoadMoreBaseAdapter<Comment, CommentsAdapter.CommentsViewHolder> {

    /**
     * Public constructor to set data to list
     *
     * @param comments List data from fragment
     */
    public CommentsAdapter(List<Comment> comments) {
        setCommentsList(comments);
    }

    @Override
    public RecyclerView.ViewHolder onCreateDataViewHolder(ViewGroup parent, int viewType) {
        Context mContext = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View commentsView = inflater.inflate(R.layout.comments_view, parent, false);
        return new CommentsAdapter.CommentsViewHolder(commentsView);
    }

    @Override
    public void onBindDataViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == VIEW_TYPE_DATA) {
            bindCommentsViewHolder((CommentsAdapter.CommentsViewHolder) holder, position);
        }


    }

    /**
     * Setting list data to base data object
     *
     * @param comments comments list
     */
    private void setCommentsList(List<Comment> comments) {
        this.data = comments;
    }

    /**
     * ViewHolder extending {@link RecyclerView.ViewHolder}
     */
    public class CommentsViewHolder extends RecyclerView.ViewHolder {
        private TextView textUserEmail;//user email
        private TextView textUserComment;//user comments on post

        public CommentsViewHolder(View itemView) {
            super(itemView);
            textUserEmail = (TextView) itemView.findViewById(R.id.item1);
            textUserComment = (TextView) itemView.findViewById(R.id.item2);
        }
    }

    /**
     * bindCommentsViewHolder--to set the data to UI
     *
     * @param commentsViewHolder base view holder
     * @param position           item position
     */
    private void bindCommentsViewHolder(CommentsAdapter.CommentsViewHolder commentsViewHolder, int position) {
        Comment comment = data.get(position);//getting data per position
        commentsViewHolder.textUserEmail.setText(comment.getEmail());
        commentsViewHolder.textUserComment.setText(comment.getBody());

    }

    /**
     * Method to replace data and notifying adapter that data has changed
     *
     * @param comments List data from fragment
     */
    public void replaceData(List<Comment> comments) {
        data.clear();//clearing data
        setCommentsList(comments);
        notifyDataSetChanged();
    }

}
