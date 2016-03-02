package com.pj.test.util;

import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Created by Administrator on 2016/2/5.
 */
public class FileUtil {

    /**
     * 将指定内容存到指定文件中
     * @param file
     * @param object
     */
    public static void savaDataToFile(File file, Object object){
        Log.d("cacheDataPath",file.getAbsolutePath());
//        Log.d("cacheDataPath", Environment.getDownloadCacheDirectory().getAbsolutePath());
        ObjectOutputStream outputStream = null;
        try {
            outputStream  = new ObjectOutputStream(new FileOutputStream(file));
            outputStream.writeObject(object);
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (outputStream!=null){
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
