package com.be_a_hero.app.activities;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.be_a_hero.app.R;
import com.be_a_hero.app.data.Tools;
import com.be_a_hero.app.databinding.ActivityRegisterDonorBinding;

public class ActivityRegisterDonor extends BaseActivity {

    private static final String TAG = ActivityRegisterDonor.class.getSimpleName();

    ActivityRegisterDonorBinding binding;

    private View parent_view;

    public static void start(Context context) {
        Intent intent = new Intent(context, ActivityRegisterDonor.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        context.startActivity(intent);
    }

    @SuppressLint({"CheckResult", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_register_donor);
        parent_view = findViewById(android.R.id.content);

        initToolbar(binding.toolbar,true);
        setToolbarTitle(null);

        Tools.systemBarLollipopTransparent(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
