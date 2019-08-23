package com.be_a_hero.app.activities;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.be_a_hero.app.R;
import com.be_a_hero.app.databinding.ActivityLoginRegisterBinding;

public class ActivityRegister extends BaseActivity {

    private static final String TAG = ActivityRegister.class.getSimpleName();

    ActivityLoginRegisterBinding binding;


    public static void start(Context context) {
        Intent intent = new Intent(context, ActivityRegister.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        context.startActivity(intent);
    }

    @SuppressLint("CheckResult")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login_register);
    }
}
