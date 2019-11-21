package com.demo.system.bars;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;

import com.demo.system.bars.utils.ScreenUtils;

/**
 * Copyright (C) 2019-11-20 Unicorn, Inc.
 * Description :
 * Created by yangzhanshan on 2019-11-20.
 */
public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ScreenUtils.setPagFullScreen(this, true);
        ScreenUtils.hideActionbar(this);
    }

    public void btnClick(View view) {
        switch (view.getId()) {
            case R.id.btn_show_statusbar:
                ScreenUtils.setStatusBarVisible(this, true);
                break;
            case R.id.btn_hide_statusbar:
                ScreenUtils.setStatusBarVisible(this, false);
                break;
            case R.id.btn_show_navigationbar:
                ScreenUtils.setNavigationBarVisible(this, true);
                break;
            case R.id.btn_hide_navigationbar:
                ScreenUtils.setNavigationBarVisible(this, false);
                break;
            case R.id.btn_show_bars:
                ScreenUtils.setSystemBarsVisible(this, true);
                break;
            case R.id.btn_hide_bars:
                ScreenUtils.setSystemBarsVisible(this, false);
                break;
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart: is run.");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume: is run.");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause: is run.");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop: is run.");
    }
}
