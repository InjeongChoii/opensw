package org.androidtown.refrigerator;

import android.util.Log;

import static android.R.attr.tag;

/**
 * 로그 편의 클래스
 * Created by stare on 2017-10-29.
 */

public class MyLog {
    private static boolean enabled = BuildConfig.DEBUG;

    public static void d(String tag, String text){
        if (!enabled) return;

        Log.d(tag, text);
    }

    public static void d(String text){
        if (!enabled) return;

        Log.d("tag", text);
    }

    public static void d(String tag, Class<?> cls, String text){
        if (!enabled) return;

        Log.d(tag, cls.getName() + "." + text);
    }

    public static void e(String tag, String text){
        if (!enabled) return;

        Log.d(tag, text);
    }
}
