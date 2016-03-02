package com.example.mylibrary;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * 获取本APK的信息
 * @author user
 *
 */
public class ApkInfoUtil {
	
	private static byte[] getSign(Context context){
    	PackageManager manager = context.getPackageManager();
    	try {
			PackageInfo info = manager.getPackageInfo(context.getPackageName(), PackageManager.GET_SIGNATURES);
			Signature[] signs = info.signatures;
			Signature sign = signs[0];
			return sign.toByteArray();
		} catch (NameNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	return null;
    }
	
	public static String getPublicKey(Context context) {
		
		       byte[] bb = getSign(context);
		        try {
		 
		            CertificateFactory certFactory = CertificateFactory
		                    .getInstance("X.509");
		            X509Certificate cert = (X509Certificate) certFactory
		                    .generateCertificate(new ByteArrayInputStream(bb));
		 
		            String publickey = cert.getPublicKey().toString();
		           
		            publickey = publickey.substring(publickey.indexOf("modulus"),
		                    publickey.indexOf(","));
		           // Log.d("TRACK", publickey);
		            return publickey;
		        } catch (CertificateException e) {
		            e.printStackTrace();
		        }
		        return null;
		    }
	
    

	public static String getApkSignInfo(String apkFilePath){
        byte[] readBuffer = new byte[8192];  
        java.security.cert.Certificate[] certs = null;  
        try{  
            JarFile jarFile = new JarFile(apkFilePath);
            Enumeration entries = jarFile.entries();
            while(entries.hasMoreElements()){  
                JarEntry je = (JarEntry)entries.nextElement();
                if(je.isDirectory()){  
                    continue;  
                }  
                if(je.getName().startsWith("META-INF/")){  
                    continue;  
                }  
                java.security.cert.Certificate[] localCerts = loadCertificates(jarFile,je,readBuffer);  
                if (certs == null) {  
                    certs = localCerts;  
                }else{  
                    for(int i=0; i<certs.length; i++){  
                        boolean found = false;  
                        for (int j = 0; j < localCerts.length; j++) {  
                            if (certs[i] != null && certs[i].equals(localCerts[j])) {  
                                  found = true;  
                                  break;  
                            }  
                        }  
                        if (!found || certs.length != localCerts.length) {  
                              jarFile.close();  
                              return null;  
                        }  
                    }  
                }  
            }  
            jarFile.close();  
            //Log.i("wind cert=",certs[0].toString());  
            return certs[0].getPublicKey().toString();  
        }catch(Exception e){
            e.printStackTrace();  
        }  
        return null;  
    }  
	private static java.security.cert.Certificate[] loadCertificates(JarFile jarFile, JarEntry je, byte[] readBuffer) {
        try {  
            InputStream is = jarFile.getInputStream(je);
            while(is.read(readBuffer,0,readBuffer.length)!=-1) {                      
            }  
            is.close();  
            return (java.security.cert.Certificate[])(je!=null?je.getCertificates():null);  
        } catch (Exception e) {
            e.printStackTrace();  
            System.err.println("Exception reading "+je.getName()+" in "+jarFile.getName()+": "+e);
        }  
        return null;  
    }  
}
