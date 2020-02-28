package com.be_a_hero.app.activities;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.be_a_hero.app.R;
import com.be_a_hero.app.adapters.DonorsAdapter;
import com.be_a_hero.app.adapters.PostsAdapter;
import com.be_a_hero.app.adapters.RequestsAdapter;
import com.be_a_hero.app.data.Constants;
import com.be_a_hero.app.databinding.ActivityRequestsBinding;

public class ActivityRequests extends BaseActivity {

    private static final String TAG = ActivityRequests.class.getSimpleName();

    ActivityRequestsBinding binding;

    private View parent_view;

    private RequestsAdapter requestsAdapter;

    public static void start(Context context) {
        Intent intent = new Intent(context, ActivityRequests.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        context.startActivity(intent);
    }

    @SuppressLint({"CheckResult", "SetTextI18n", "ResourceAsColor"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_requests);
        parent_view = findViewById(android.R.id.content);

        initToolbar(binding.requestsToolbar.toolbar,true);

        bindRecyclerView();
    }

    private void bindRecyclerView() {
        // show the users
        binding.usersRecyclerView.setLayoutManager(new LinearLayoutManager(activityContext));
        binding.usersRecyclerView.setHasFixedSize(true);
        binding.usersRecyclerView.setNestedScrollingEnabled(false);
        //set data and list adapter
        requestsAdapter = new RequestsAdapter(activityContext, Constants.getUsers(activityContext));
        binding.usersRecyclerView.setAdapter(requestsAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            onBackPressed();
            return true;
        }else{
            Snackbar.make(parent_view, item.getTitle()+" clicked", Snackbar.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {
        getMenuInflater().inflate(R.menu.menu_activity_donors, menu);
        return true;
    }
}
