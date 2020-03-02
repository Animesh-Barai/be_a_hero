package com.be_a_hero.app.activities;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.be_a_hero.app.R;
import com.be_a_hero.app.databinding.ActivityUserProfileBinding;

public class ActivityUserProfile extends BaseActivity {

    private static final String TAG = ActivityUserProfile.class.getSimpleName();

    ActivityUserProfileBinding binding;

    private View parent_view;

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
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {
        return true;
    }
}
