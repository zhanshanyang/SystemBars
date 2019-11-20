package com.demo.system.bars;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.demo.system.bars.utils.ScreenUtils;

/**
 * Copyright (C) 2019-11-20 Unicorn, Inc.
 * Description :
 * Created by yangzhanshan on 2019-11-20.
 */
public class MainActivity extends AppCompatActivity {

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
}
