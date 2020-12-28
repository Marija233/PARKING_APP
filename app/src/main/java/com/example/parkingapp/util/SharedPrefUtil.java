package com.example.parkingapp.util;

import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

public final class SharedPrefUtil {

    private static final String MY_PREF_NAME = "my.pref.name";
    public static final String EMAIL_KEY = "email";

    private SharedPrefUtil() {
    }

    public static void saveUserEmail(Context context, String email) {
        SharedPreferences.Editor editor = context.getSharedPreferences(MY_PREF_NAME, MODE_PRIVATE).edit();
        editor.putString(EMAIL_KEY, email);
        editor.apply();
    }

    public static String getUserEmail(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(MY_PREF_NAME, MODE_PRIVATE);
        return prefs.getString(EMAIL_KEY, "");
    }
}
