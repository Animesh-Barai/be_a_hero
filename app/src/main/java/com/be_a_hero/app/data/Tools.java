package com.be_a_hero.app.data;

import android.app.Activity;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;

import com.be_a_hero.app.R;

public class Tools {
    private static float getAPIVersison() {

        float f;
        try {
            f = Float.parseFloat(Build.VERSION.RELEASE.substring(0, 1));
        } catch (NumberFormatException e) {
            f = 1.0f;
            Log.e("", "Error on getting API version " + e.getMessage());
        }

        return f;
    }

    public static void systemBarLollipop(Activity act) {
        if (getAPIVersison() >= 5.0) {
            Window window = act.getWindow();
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                window.setStatusBarColor(act.getResources().getColor(R.color.colorPrimaryDark));
            }
        }
    }

    public static void systemBarLollipopTransparent(Activity act) {
        if (getAPIVersison() >= 5.0) {
            Window window = act.getWindow();
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                window.setStatusBarColor(act.getResources().getColor(android.R.color.transparent));
            }
        }
    }

    public static int getGridSpanCount(Activity activity) {
        Display display = activity.getWindowManager().getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        display.getMetrics(displayMetrics);
        float screenWidth  = displayMetrics.widthPixels;
        float cellWidth = activity.getResources().getDimension(R.dimen.recycler_item_size);
        return Math.round(screenWidth / cellWidth);
    }
}
