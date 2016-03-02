package com.example.mylibrary;

import android.app.Activity;

import android.view.Window;
import android.view.WindowManager;

/**
 *安全性工具
 * Created by user on 2015/12/30.
 */
public class SecurityUtility {

    /**
     * 防截屏
     * @param activity
     */
    public static void antiScreenshot(Activity activity) {

        Window win = activity.getWindow();
        win.addFlags(WindowManager.LayoutParams.FLAG_SECURE);
    }


}
