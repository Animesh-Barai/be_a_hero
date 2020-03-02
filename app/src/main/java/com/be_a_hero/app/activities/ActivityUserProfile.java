package com.be_a_hero.app.activities;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.be_a_hero.app.R;
import com.be_a_hero.app.adapters.DonorsAdapter;
import com.be_a_hero.app.adapters.PostsAdapter;
import com.be_a_hero.app.data.Constants;
import com.be_a_hero.app.databinding.ActivityUserProfileBinding;
import com.be_a_hero.app.models.Posts;
import com.be_a_hero.app.models.RowItem;
import com.be_a_hero.app.models.UsersListItem;

import java.util.ArrayList;
import java.util.List;

public class ActivityUserProfile extends BaseActivity {

    private static final String TAG = ActivityUserProfile.class.getSimpleName();

    ActivityUserProfileBinding binding;

    private View parent_view;
    private PostsAdapter postsAdapter;

    public static void start(Context context) {
        Intent intent = new Intent(context, ActivityUserProfile.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_user_profile);
        parent_view = findViewById(android.R.id.content);

        initToolbar(binding.toolbar,true);

        bindRecyclerView();
    }

    private void bindRecyclerView() {
        // show the list of recent activity
        binding.recentActivityRecyclerView.setLayoutManager(new LinearLayoutManager(activityContext));
        binding.recentActivityRecyclerView.setHasFixedSize(true);
        binding.recentActivityRecyclerView.setNestedScrollingEnabled(false);
        //set data and list adapter
        postsAdapter = new PostsAdapter(activityContext, null);
        binding.recentActivityRecyclerView.setAdapter(postsAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        generateListForRecentActivity(Constants.getPosts(activityContext));
    }

    private void generateListForRecentActivity(List<Posts> posts) {
        // Create new list of posts
        // add the first and last item
        List<Posts> newPostsList = new ArrayList<>();
        newPostsList.add(posts.get(0));
        newPostsList.add(posts.get((posts.size()-1)));

        // refresh the adapter
        postsAdapter.setPostsList(newPostsList);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {
        return true;
    }
}
