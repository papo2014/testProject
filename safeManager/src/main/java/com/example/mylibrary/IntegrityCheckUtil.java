
package com.example.mylibrary;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * 完整性检验
 * Created by lenovo on 2015/12/15.
 */
public class IntegrityCheckUtil {
    private Context mContext;

    public IntegrityCheckUtil(Context context) {
        this.mContext = context;
    }

    /**
     * 验证res文件的完整性
     * @param integrityMd5
     * @return
     */
    public boolean isResIntegrity(String integrityMd5) {
        JarFile jarFile = null;
        boolean isIntegrity = true;
        try {
            jarFile = new JarFile(mContext.getPackageResourcePath());
            Enumeration entries = jarFile.entries();
            StringBuffer buffer = new StringBuffer();
            while (entries.hasMoreElements()) {
                JarEntry ze = (JarEntry) entries.nextElement();
                if (ze.getName().contains("res")) {
                    InputStream in = jarFile.getInputStream(ze);
                    buffer.append(MD5Util.md5sum(in));
                }
            }
            Log.e("taggg",MD5Util.get(buffer.toString()));
            if (!MD5Util.get(buffer.toString()).equals(integrityMd5)) {
                isIntegrity = false;
            } else {
                isIntegrity = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (jarFile != null) {
                    jarFile.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return isIntegrity;
    }

    /**
     * 检查assets的完整性
     * @param integrityMd5
     * @return
     */
    public boolean isAssetsIntegrity(String integrityMd5) {
        JarFile jarFile = null;
        boolean isIntegrity = true;
        try {
            jarFile = new JarFile(mContext.getPackageResourcePath());
            Enumeration entries = jarFile.entries();
            StringBuffer buffer = new StringBuffer();
            while (entries.hasMoreElements()) {
                JarEntry ze = (JarEntry) entries.nextElement();
                if (ze.getName().contains("assets")) {
                    InputStream in = jarFile.getInputStream(ze);
                    buffer.append(MD5Util.md5sum(in));
                }
            }
            Log.e("taggg",MD5Util.get(buffer.toString()));
            if (!MD5Util.get(buffer.toString()).equals(integrityMd5)) {
                isIntegrity = false;
            } else {
                isIntegrity = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (jarFile != null) {
                    jarFile.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return isIntegrity;
    }

    public String getSign(String packageName) {
        Signature[] arrayOfSignature = getRawSignature(mContext, packageName);
        if ((arrayOfSignature != null) && (arrayOfSignature.length != 0)) {
            StringBuffer stringBuffer = new StringBuffer();
            int i = arrayOfSignature.length;
            for (int j = 0; j < i; j++) {
                stringBuffer.append(MD5Util.getMessageDigest(arrayOfSignature[j].toByteArray()));
            }
            return stringBuffer.toString();
        } else {
            return null;
        }
    }

    private Signature[] getRawSignature(Context paramContext, String paramString) {
        if ((paramString == null) || (paramString.length() == 0)) {
            return null;
        }
        PackageManager localPackageManager = paramContext.getPackageManager();
        PackageInfo localPackageInfo;
        try {
            localPackageInfo = localPackageManager.getPackageInfo(paramString, 64);
            if (localPackageInfo == null) {
                return null;
            }
        } catch (PackageManager.NameNotFoundException localNameNotFoundException) {
            return null;
        }
        return localPackageInfo.signatures;
    }
}
