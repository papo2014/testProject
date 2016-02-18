package com.pj.test.util;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/**
 * 数据缓存管理器,sdcard存儲具有高優先級
 * <p/>
 * Created by Administrator on 2016/a2/5.
 */
public class DataCacheManager {
    private final File dataFileDir;
    private final File sdCardFileDir;
    private Context mContext;
    private static DataCacheManager dataCacheManager = null;

    private DataCacheManager(Context mContext) {
        this.mContext = mContext;
        dataCacheDir = mContext.getCacheDir();
        sdCardCacheDir = mContext.getExternalCacheDir();
        dataFileDir = mContext.getFilesDir();
        sdCardFileDir = mContext.getExternalFilesDir(null);

    }

    public static DataCacheManager getInstance(Context context) {
        if (dataCacheManager == null) {
            dataCacheManager = new DataCacheManager(context);
        }
        return dataCacheManager;
    }

    private File dataCacheDir;
    private File sdCardCacheDir;

    /**
     * 将数据存入data/包名/cache缓存目前
     *
     * @param fileName
     */
    public void savaDataToCache(String fileName, Object object) {
        File file = null;
        if (SdCardUtil.isSdCardMounted()) {
            file = new File(sdCardCacheDir, fileName);
        } else {
            file = new File(dataCacheDir, fileName);

        }
        FileUtil.savaDataToFile(file, object);
    }

    /**
     * 将数据存入data/包名/cache內部缓存目前
     *
     * @param fileName
     */
    public void savaDataToInnerCache(String fileName, Object object) {
        File file = null;

        file = new File(dataCacheDir, fileName);

        FileUtil.savaDataToFile(file, object);
    }


    /**
     * 将数据存入data/file目錄
     *
     * @param fileName
     */
    public void savaDataToFilePath(String fileName, Object object) {
        File file = null;
        if (SdCardUtil.isSdCardMounted()) {
            file = new File(sdCardFileDir, fileName);
        } else {
            file = new File(dataFileDir, fileName);

        }
        FileUtil.savaDataToFile(file, object);
    }

    /**
     * 将数据存入內部data/file目錄
     *
     * @param fileName
     */
    public void savaDataToInnerFilePath(String fileName, Object object) {
        File file = null;

        file = new File(dataFileDir, fileName);

        FileUtil.savaDataToFile(file, object);
    }

    /**
     * 将数据存入內部cache目錄(無權限寫入)
     *
     * @param fileName
     */
    public void savaDataToDownlaodCache(String fileName, Object object) {
        File file = null;

        file = new File( Environment.getDownloadCacheDirectory(), fileName);

        FileUtil.savaDataToFile(file, object);
    }

    /**
     * 将数据存入sdcard
     *
     * @param fileName
     */
    public void savaDataToSdcard(String fileName, Object object) {
        File file = null;

        file = new File( Environment.getExternalStorageDirectory(), fileName);

        FileUtil.savaDataToFile(file, object);
    }

}
