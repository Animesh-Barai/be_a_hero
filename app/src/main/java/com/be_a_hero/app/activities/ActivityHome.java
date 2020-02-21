package com.be_a_hero.app.activities;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;

import com.be_a_hero.app.R;
import com.be_a_hero.app.databinding.ActivityHomeBinding;

public class ActivityHome extends BaseActivity {

    private static final String TAG = ActivityHome.class.getSimpleName();

    ActivityHomeBinding binding;

    private View parent_view;

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

        initToolbar(binding.toolbar,false);
    }
}
