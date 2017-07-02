package com.holidaypirates.userposts.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.holidaypirates.userposts.R;
import com.holidaypirates.userposts.model.User;

import java.util.List;

/**
 *{@link UsersAdapter -- Adapter to have ui to show details of users list}
 * @author Sanjay mallur
 */

public class UsersAdapter extends LoadMoreBaseAdapter<User, UsersAdapter.UsersViewHolder> {

    /**
     * Public constructor to set data to list
     *
     * @param users List data from fragment
     */
    public UsersAdapter(List<User> users) {
        setUsersList(users);
    }

    @Override
    public RecyclerView.ViewHolder onCreateDataViewHolder(ViewGroup parent, int viewType) {
        Context mContext = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View commentsView = inflater.inflate(R.layout.comments_view, parent, false);
        return new UsersAdapter.UsersViewHolder(commentsView);
    }

    @Override
    public void onBindDataViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == VIEW_TYPE_DATA) {
            bindUsersViewHolder((UsersAdapter.UsersViewHolder) holder, position);
        }


    }
    /**
     * Setting list data to base data object
     * @param users comments list
     */
    private void setUsersList(List<User> users) {
        this.data = users;
    }

    /**
     * ViewHolder extending {@link RecyclerView.ViewHolder}
     */
    public class UsersViewHolder extends RecyclerView.ViewHolder {
        private TextView textUserEmail;//user email
        private TextView textUserComment;//user comment on the post
        public UsersViewHolder(View itemView) {
            super(itemView);
            textUserEmail = (TextView) itemView.findViewById(R.id.item1);
            textUserComment=(TextView)itemView.findViewById(R.id.item2);
        }
    }

    /**
     * bindCommentsViewHolder--to set the data to UI
     * @param userssViewHolder base view holder
     * @param position           item position
     */
    private void bindUsersViewHolder(UsersAdapter.UsersViewHolder userssViewHolder, int position) {
        User user = data.get(position);
        userssViewHolder.textUserEmail.setText(user.getName());
        userssViewHolder.textUserComment.setText(user.getEmail());


    }
    /**
     * Method to replace data and notifying adapter that data has changed
     * @param users List data from fragment
     */
    public void replaceData(List<User> users) {
        data.clear();
        setUsersList(users);
        notifyDataSetChanged();
    }

}
