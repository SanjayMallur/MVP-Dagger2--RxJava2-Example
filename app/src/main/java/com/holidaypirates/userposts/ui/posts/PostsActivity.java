package com.holidaypirates.userposts.ui.posts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.holidaypirates.userposts.R;
/**
 * {@link PostsActivity --Activity to have detailed contents example: userFragment,PhotoFragment, CommentFragment}
 * @author Sanjay Mallur
 * */
public class PostsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//layout for adding fragment
    }
}
