package com.demo.system.bars;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;

import com.demo.system.bars.utils.ScreenUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (C) 2019-11-20 Unicorn, Inc.
 * Description :
 * Created by yangzhanshan on 2019-11-20.
 */
public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private ShortcutManager mShortcutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mShortcutManager = (ShortcutManager) getSystemService(SHORTCUT_SERVICE);
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

    private static final String SHORTCUT_ID = "shortcut_id";
    private static final String SHORTCUT_ID1 = "shortcut_id1";
    private static final String SHORTCUT_ID2 = "shortcut_id2";
    //点击按钮生成相应的捷径
    public void btnClickSC(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.setAction(Intent.ACTION_VIEW);
        switch (view.getId()) {
            case R.id.btn_shortcut:
                ShortcutInfo shortcutInfo = new ShortcutInfo.Builder(this, SHORTCUT_ID)
                        .setShortLabel("ShortLabel")
                        .setIntent(intent)
                        .build();
                addOrRemoveShortCut(shortcutInfo);
                break;
            case R.id.btn_shortcut_txt:
                ShortcutInfo shortcutInfo1 = new ShortcutInfo.Builder(this, SHORTCUT_ID1)
                        .setShortLabel("ShortLabel")
                        .setLongLabel("随便看看")
                        .setIntent(intent)
                        .build();
                addOrRemoveShortCut(shortcutInfo1);
                break;
            case R.id.btn_shortcut_pic:
                ShortcutInfo shortcutInfo2 = new ShortcutInfo.Builder(this, SHORTCUT_ID2)
                        .setShortLabel("ShortLabel")
                        .setIcon(Icon.createWithResource(this, R.drawable.tmp))
                        .setIntent(intent)
                        .build();
                addOrRemoveShortCut(shortcutInfo2);
                break;
        }
    }

    private void addOrRemoveShortCut(ShortcutInfo info) {
        List<ShortcutInfo> dynamicShortcuts = mShortcutManager.getDynamicShortcuts();
        boolean isExist = false;
        for (ShortcutInfo item : dynamicShortcuts) {
            if (TextUtils.equals(info.getId(), item.getId())) {
                isExist = true;
            }
        }
        if (isExist) {
            List<String> ids = new ArrayList<>();
            ids.add(info.getId());
            mShortcutManager.removeDynamicShortcuts(ids);
        } else {
            List<ShortcutInfo> infos = new ArrayList<>();
            infos.add(info);
            mShortcutManager.addDynamicShortcuts(infos);
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

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        Log.i(TAG, "onWindowFocusChanged: is run.hasFocus:" + hasFocus);
    }

    public void btnClick3(View view) {
        switch (view.getId()) {
            case R.id.btn_dialog:
                showOrDismissDialog();
                break;
        }
    }

    private AlertDialog mAlertDialog;
    private void showOrDismissDialog() {
        if (mAlertDialog == null) {
            mAlertDialog = new AlertDialog(this, R.style.MyDialogStyle) {
                @Override
                protected void onCreate(Bundle savedInstanceState) {
                    super.onCreate(savedInstanceState);
                    getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |
                            View.SYSTEM_UI_FLAG_LAYOUT_STABLE |
                            View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
                    setContentView(R.layout.view_dialog);
                    findViewById(R.id.btn_cancel).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dismiss();
                        }
                    });
                }
            };
        }
        mAlertDialog.show();
    }
}
