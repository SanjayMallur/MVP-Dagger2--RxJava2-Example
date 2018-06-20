package com.example.userposts.ui.postdetail;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.userposts.R;

/**
* {@link PostDetailActivity --Activity to have detailed contents ex user fragment,photos fragment, comments fragment}
* @author Sanjay Mallur
* */
public class PostDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_detail);//Layout to have multiple fragments

    }

}
