package com.be_a_hero.app.data;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;

import com.be_a_hero.app.R;
import com.be_a_hero.app.models.Users;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Constants {

    private static Random rnd = new Random();

    // demo users
    @SuppressLint("Recycle")
    public static List<Users> getUsers(Context ctx) {
        List<Users> items = new ArrayList<>();
        String[] names_arr = ctx.getResources().getStringArray(R.array.people_names);
        TypedArray imgs_arr = ctx.getResources().obtainTypedArray(R.array.people_photos);
        String[] locations_arr = ctx.getResources().getStringArray(R.array.people_locations);
        String[] blood_groups_arr = ctx.getResources().getStringArray(R.array.blood_groups);
        String[] dates_arr = ctx.getResources().getStringArray(R.array.last_donation_dates);

        for (int i = 0; i < names_arr.length ; i++) {
            Users item = new Users(i+1,names_arr[i], imgs_arr.getResourceId(i, -1), getRandomValue(ctx, locations_arr), "+91 "+String.valueOf(getRandomIndex(rnd,731234567,732234567)), blood_groups_arr[i], getRandomValue(ctx, dates_arr));
            items.add(item);
        }
        Collections.shuffle(items, rnd);
        return items;
    }

    private static int getRandomIndex(Random r, int min, int max) {
        return r.nextInt(max - min) + min;
    }

    private static String getRandomValue(Context ctx, String[] parsed_arr) {
        return parsed_arr[getRandomIndex(rnd, 0, parsed_arr.length - 1)];
    }
}
