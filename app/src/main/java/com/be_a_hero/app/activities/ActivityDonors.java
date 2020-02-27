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
import com.be_a_hero.app.adapters.PostsAdapter;
import com.be_a_hero.app.data.Constants;
import com.be_a_hero.app.databinding.ActivityDonorsBinding;
import com.be_a_hero.app.databinding.ActivityHomeBinding;

public class ActivityDonors extends BaseActivity {

    private static final String TAG = ActivityDonors.class.getSimpleName();

    ActivityDonorsBinding binding;

    private View parent_view;

    public static void start(Context context) {
        Intent intent = new Intent(context, ActivityDonors.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        context.startActivity(intent);
    }

    @SuppressLint({"CheckResult", "SetTextI18n", "ResourceAsColor"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_donors);
        parent_view = findViewById(android.R.id.content);

        initToolbar(binding.toolbar,true);

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
