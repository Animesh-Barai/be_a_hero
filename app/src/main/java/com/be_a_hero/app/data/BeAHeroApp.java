package com.be_a_hero.app.data;

import android.content.Context;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;
import android.support.v7.app.AppCompatDelegate;

import com.be_a_hero.app.utils.TypefaceUtil;


public class BeAHeroApp extends MultiDexApplication {

    public static final String TAG = BeAHeroApp.class.getSimpleName();
    private static BeAHeroApp mInstance;

    /**
     * Gets the application context.
     *
     * @return the application context
     */
    public static Context getContext() {
        if (mInstance == null) {
            mInstance = new BeAHeroApp();
        }
        return mInstance;
    }

    public static synchronized BeAHeroApp getInstance() {
        return mInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        MultiDex.install(this);
        TypefaceUtil.overrideFont(getApplicationContext(), "SERIF", "fonts/montserrat_light.ttf");

        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}
