package com.be_a_hero.app.activities;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.be_a_hero.app.R;
import com.be_a_hero.app.databinding.ActivitySplashBinding;
import com.be_a_hero.app.databinding.ActivityWelcomeScreenBinding;

public class ActivityWelcomeScreen extends AppCompatActivity {

    private static final String TAG = ActivityWelcomeScreen.class.getSimpleName();

    ActivityWelcomeScreenBinding binding;

    private View parent_view;

    public static void start(Context context) {
        Intent intent = new Intent(context, ActivityWelcomeScreen.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_welcome_screen);
        parent_view = findViewById(android.R.id.content);
    }
}
