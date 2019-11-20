package com.demo.system.bars.utils;

import android.app.ActionBar;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Build;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Copyright (C) 2019-11-20 Unicorn, Inc.
 * Description :
 * Created by yangzhanshan on 2019-11-20.
 */
public class ScreenUtils {

    /**
     * 隐藏actionbar
     * @param activity
     */
    public static void hideActionbar(AppCompatActivity activity) {
        androidx.appcompat.app.ActionBar supportActionBar = activity.getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.hide();
        }
        ActionBar actionBar = activity.getActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
    }

    /**
     * 设置navigationBar的背景颜色为透明
     * @param activity
     */
    public static void setNavigationBarTranslucent(Activity activity) {
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
            activity.getWindow().setNavigationBarColor(Color.TRANSPARENT);
        }
    }

    /**
     * 退出全屏
     * @param activity
     */
    public static void exitFullScreen(Activity activity) {
        activity.getWindow().clearFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    /**
     * 进入全屏
     * @param activity
     */
    public static void enterFullScreen(Activity activity) {
        activity.getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    /**
     * 设置StatusBar的显示和隐藏
     * @param activity
     * @param show
     */
    public static void setStatusBarVisible(Activity activity, boolean show) {
        if (show) {
            activity.getWindow().clearFlags(
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
        } else {
            activity.getWindow().setFlags(
                    WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
    }

    /**
     * 设置NavigationBar的显示和隐藏
     * @param activity
     * @param show
     */
    public static void setNavigationBarVisible(Activity activity, boolean show) {
        if (show) {
            int uiFlags = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN;
            uiFlags |= View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
            activity.getWindow().getDecorView().setSystemUiVisibility(uiFlags);
        } else {
            int uiFlags = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
            uiFlags |= View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
            activity.getWindow().getDecorView().setSystemUiVisibility(uiFlags);

            activity.getWindow().getDecorView().getSystemUiVisibility();
        }
    }

    /**
     * 同时显示和隐藏M01中控
     * StatusBar 和 NavigationBar
     * @param activity this
     * @param show true:显示
     *             false:隐藏
     */
    public static void setSystemBarsVisible(Activity activity, boolean show) {
        if (show) {
            int uiFlags = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN;
            uiFlags |= View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
            activity.getWindow().getDecorView().setSystemUiVisibility(uiFlags);
        } else {
            int uiFlags = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_FULLSCREEN;
            uiFlags |= View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
            activity.getWindow().getDecorView().setSystemUiVisibility(uiFlags);
        }
    }

    /**
     * 应用的页面占满全屏，同时StatusBar显示
     * @param activity activity
     * @param show true:全屏 false:预留Statusbar的空间
     */
    public static void setPagFullScreen(Activity activity, boolean show) {
        if (show) {
            int uiFlags = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN;
            activity.getWindow().getDecorView().setSystemUiVisibility(uiFlags);
            activity.getWindow().setStatusBarColor(Color.TRANSPARENT);
        } else {
            int uiFlags = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
            activity.getWindow().getDecorView().setSystemUiVisibility(uiFlags);
        }
    }

    /**
     * Take screen shot of the View
     *
     * 截部分view成图片
     * @param v the view
     *
     * @return screenshot of the view as bitmap
     */
    public static Bitmap takeScreenShotOfView(View v) {
        long startTime = SystemClock.uptimeMillis();

        v.setDrawingCacheEnabled(true);

        v.buildDrawingCache(true);

        // creates immutable clone
        Bitmap b = Bitmap.createBitmap(v.getDrawingCache());
        v.setDrawingCacheEnabled(false); // clear drawing cache
        Log.i("ScreenUtils", "takeScreenShotOfView: time:" + (SystemClock.uptimeMillis() - startTime));
        return b;
    }

}
