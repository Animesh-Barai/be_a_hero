package com.be_a_hero.app.data;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.format.DateFormat;

import com.be_a_hero.app.R;
import com.be_a_hero.app.models.Posts;
import com.be_a_hero.app.models.Users;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
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

    // demo posts
    @SuppressLint("Recycle")
    public static List<Posts> getPosts(Context ctx) {
        List<Posts> items = new ArrayList<>();

        List<Users> users_arr = getUsers(ctx);
        String[] time_arr = ctx.getResources().getStringArray(R.array.post_dates);
        String[] content_arr = ctx.getResources().getStringArray(R.array.post_content);
        TypedArray imgs_arr = ctx.getResources().obtainTypedArray(R.array.post_images);

        for (int i = 0; i < content_arr.length ; i++) {
            Posts item = new Posts(i+1, users_arr.get(i), getRandomValue(ctx, time_arr), content_arr[i], imgs_arr.getResourceId(i, -1));
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

    // calculate time ago from given date
    public static String timeAgoTimeDiff(Date startDate, Date endDate) {

        long timeDifferenceMilliseconds = endDate.getTime() - startDate.getTime();

        long diffSeconds = timeDifferenceMilliseconds / 1000;
        long diffMinutes = timeDifferenceMilliseconds / (60 * 1000);
        long diffHours = timeDifferenceMilliseconds / (60 * 60 * 1000);
        long diffDays = timeDifferenceMilliseconds / (60 * 60 * 1000 * 24);
        long diffWeeks = timeDifferenceMilliseconds / (60 * 60 * 1000 * 24 * 7);
        long diffMonths = (long) (timeDifferenceMilliseconds / (60 * 60 * 1000 * 24 * 30.41666666));
        long diffYears = timeDifferenceMilliseconds / ((long)60 * 60 * 1000 * 24 * 365);

        if (diffSeconds < 1) {
            return "1 second";
        }else if (diffMinutes < 1) {
            return diffSeconds + " Seconds";
        }//Minutes
        else if (diffMinutes <= 60) {
            if (diffMinutes == 1) {
                return "1 Minute";
            } else {
                return diffMinutes + " Minutes";
            }
        }else{
            return DateFormat.format("dd-MMM-yyyy", new Date(endDate.getTime())).toString();
        }
    }
}
