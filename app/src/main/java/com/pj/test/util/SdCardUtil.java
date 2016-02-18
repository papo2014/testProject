package com.pj.test.util;

import android.os.Environment;

/**
 *
 * Created by Administrator on 2016/2/5.
 */
public class SdCardUtil {
    /**
     * 判断sdcard是否可以读写
     * @return boolean
     */
    public static boolean isSdCardMounted(){
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED))
            return true;

        return false;
    }
}
