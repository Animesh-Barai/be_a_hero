package com.be_a_hero.app.activities;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.be_a_hero.app.R;
import com.be_a_hero.app.data.Tools;
import com.be_a_hero.app.databinding.ActivitySplashBinding;
import com.be_a_hero.app.databinding.ActivityWelcomeScreenBinding;

public class ActivityWelcomeScreen extends BaseActivity {

    private static final String TAG = ActivityWelcomeScreen.class.getSimpleName();

    ActivityWelcomeScreenBinding binding;

    private View parent_view;
    private IntroSliderPagerAdapter introSliderPagerAdapter;
    private TextView[] bottomBars;
    private int[] layouts;

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

        // Making notification bar transparent
//        if (Build.VERSION.SDK_INT >= 21) {
//            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
//        }

        binding = DataBindingUtil.setContentView(this, R.layout.activity_welcome_screen);
        parent_view = findViewById(android.R.id.content);

        // layouts of all welcome sliders
        layouts = new int[]{
                R.layout.fragment_welcome_slide1,
                R.layout.fragment_welcome_slide2,
                R.layout.fragment_welcome_slide3
        };

        // the viewpager
        introSliderPagerAdapter = new IntroSliderPagerAdapter();
        binding.viewPager.setAdapter(introSliderPagerAdapter);
        binding.viewPager.addOnPageChangeListener(viewPagerPageChangeListener);
        binding.tabDots.setupWithViewPager(binding.viewPager, true);

//        Tools.systemBarLollipopTransparent(this);
    }

    //  viewpager change listener
    ViewPager.OnPageChangeListener viewPagerPageChangeListener = new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageSelected(int position) {
//            addBottomDots(position);
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {

        }

        @Override
        public void onPageScrollStateChanged(int arg0) {

        }
    };

    /**
     * View pager adapter
     */
    public class IntroSliderPagerAdapter extends PagerAdapter {
        private LayoutInflater layoutInflater;

        IntroSliderPagerAdapter() { }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View view = layoutInflater.inflate(layouts[position], container, false);
            container.addView(view);

            return view;
        }

        @Override
        public int getCount() {
            return layouts.length;
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
            return view == obj;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            View view = (View) object;
            container.removeView(view);
        }
    }
}
