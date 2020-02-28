package com.be_a_hero.app.activities;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.be_a_hero.app.R;
import com.be_a_hero.app.adapters.PostsAdapter;
import com.be_a_hero.app.data.Constants;
import com.be_a_hero.app.databinding.ActivityHomeBinding;

public class ActivityHome extends BaseActivity {

    private static final String TAG = ActivityHome.class.getSimpleName();

    ActivityHomeBinding binding;

    private View parent_view;
    private PostsAdapter postsAdapter;

    public static void start(Context context) {
        Intent intent = new Intent(context, ActivityHome.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        context.startActivity(intent);
    }

    @SuppressLint({"CheckResult", "SetTextI18n", "ResourceAsColor"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home);
        parent_view = findViewById(android.R.id.content);

        //initToolbar(binding.toolbar,false);

        initViews();

    }

    private void initViews() {

        // show all the donors
        binding.homeContentTop.buttonFindDonor.setOnClickListener(v -> {
            ActivityDonors.start(activityContext);
        });

        // show the requests
        binding.homeContentTop.buttonViewRequests.setOnClickListener(v -> {
            ActivityRequests.start(activityContext);
        });

        // show the posts
        binding.postsRecyclerView.setLayoutManager(new LinearLayoutManager(activityContext));
        binding.postsRecyclerView.setHasFixedSize(true);
        binding.postsRecyclerView.setNestedScrollingEnabled(false);
        //set data and list adapter
        postsAdapter = new PostsAdapter(activityContext, Constants.getPosts(activityContext));
        binding.postsRecyclerView.setAdapter(postsAdapter);
    }
}
