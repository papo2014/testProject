//
// Created by Administrator on 2016/2/26.
//
#include<stdio.h>
#include<jni.h>
#include"3des.h"

#include "desjni.h"
#include <string.h>
//#include <windows.h>
char key[24]={ 'a', '3', 'a', 'c', 'd', '7','9','a', 'b', '3', 'd', 'c', 'd', 'v','9'};

char*   Jstring2CStr(JNIEnv*   env,   jstring   jstr) {
    char *rtn = NULL;
    jclass clsstring = (*env)->FindClass(env,"java/lang/String");
    jstring strencode = (*env)->NewStringUTF(env,"GB2312");
    jmethodID mid = (*env)->GetMethodID(env,clsstring, "getBytes", "(Ljava/lang/String;)[B");
    jbyteArray barr = (jbyteArray) (*env)->CallObjectMethod(env,jstr, mid, strencode);
    jsize alen = (*env)->GetArrayLength(env,barr);
    jbyte *ba = (*env)->GetByteArrayElements(env,barr, JNI_FALSE);
    if (alen > 0) {
        rtn = (char *) malloc(alen + 1);         //new   char[alen+1];
        memcpy(rtn, ba, alen);
        rtn[alen] = 0;
    }
    (*env)->ReleaseByteArrayElements(env,barr, ba, 0);
    return rtn;
}

jstring CStr2Jstring( JNIEnv* env, const char* pat )
{
    jsize   len   =   strlen(pat);

    jclass   clsstring   =   (*env)->FindClass(env, "java/lang/String");
    jstring   strencode   =   (*env)->NewStringUTF(env,"GB2312");

    jmethodID   mid   =   (*env)->GetMethodID(env,clsstring,   "<init>",   "([BLjava/lang/String;)V");
    jbyteArray   barr   =   (*env)-> NewByteArray(env,len);

    (*env)-> SetByteArrayRegion(env,barr,0,len,(jbyte*)pat);
    return (jstring)(*env)-> NewObject(env,clsstring,mid,barr,strencode);
}
/*
 * Class:     com_pj_test_util_DESTool
 * Method:    l
 * Signature: (Ljava/lang/String;)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_com_pj_test_util_DESTool_decrypt
        (JNIEnv *env, jclass cls, jstring string) {
    char result[64];//可以先分配一个足够大的存储空间，根据明文长度来取解密后的消息长度
    char *rtn ;
    rtn = Jstring2CStr(env,string);


//获得java.lang.String类的一个实例
//    jclass clsstring = (*env)->FindClass(env, "java/lang/String");
////指定编码方式
//    jstring strencode = (*env)->NewStringUTF(env, "utf-8");//utf-16,GB2312
////获得方法 getBytes
//    jmethodID mid = (*env)->GetMethodID(env, clsstring, "getBytes", "(Ljava/lang/String;)[B");
////通过回调java中的getBytes方法将字符串jstr转换成uft-8编码的字节数组
//    jbyteArray barr = (jbyteArray)(*env)->CallObjectMethod(env, string, mid, strencode);
//// String .getByte("GB2312");
////获得字节数组的长度
//    jsize alen = (*env)->GetArrayLength(env, barr);
////获得字节数组的首地址
//    jbyte *ba = (*env)->GetByteArrayElements(env, barr, JNI_FALSE);
//    if (alen > 0) {
////分配内存空间
//        rtn = (char *) malloc(alen + 1); //new char[alen+1]; "\0"
////将字符串ba复制到 rtn
//        memcpy(rtn, ba, alen);
//        rtn[alen] = 0;
//    }
//    (*env)->ReleaseByteArrayElements(env, barr, ba, 0); //释放内存
    Decrypt(rtn, key, result, sizeof(rtn));

//    char* p = Jstring2CStr(env,rtn);
    return (*env)->NewStringUTF(env, result);
}

/*
 * Class:     com_pj_test_util_DESTool
 * Method:    a
 * Signature: (Ljava/lang/String;)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_com_pj_test_util_DESTool_encrypt
        (JNIEnv *env, jclass cls, jstring string) {
    char cipher[64];//可以先分配一个足够大的存储空间存储中间密文结果
    char *rtn ;
    rtn =  Jstring2CStr(env,string);
//    rtn = jstringToWindows(env,string);
//    const char* s = (*env)->GetStringUTFChars(env,string, NULL);
////获得java.lang.String类的一个实例
//    jclass clsstring = (*env)->FindClass(env, "java/lang/String");
////指定编码方式
//    jstring strencode = (*env)->NewStringUTF(env, "utf-8");//utf-16,GB2312
////获得方法 getBytes
//    jmethodID mid = (*env)->GetMethodID(env, clsstring, "getBytes", "(Ljava/lang/String;)[B");
////通过回调java中的getBytes方法将字符串jstr转换成uft-8编码的字节数组
//    jbyteArray barr = (jbyteArray)(*env)->CallObjectMethod(env, string, mid, strencode);
//// String .getByte("GB2312");
////获得字节数组的长度
//    jsize alen = (*env)->GetArrayLength(env, barr);
////获得字节数组的首地址
//    jbyte *ba = (*env)->GetByteArrayElements(env, barr, JNI_FALSE);
//    if (alen > 0) {
////分配内存空间
//        rtn = (char *) malloc(alen + 1); //new char[alen+1]; "\0"
////将字符串ba复制到 rtn
//        memcpy(rtn, ba, alen);
//        rtn[alen] = 0;
//    }
//(*env)->ReleaseByteArrayElements(env, barr, ba, 0); //释放内存
    Encrypt(rtn, key, cipher, sizeof(rtn));
//    Encrypt(s, key, cipher, sizeof(s));
//    jstring jstr = WindowsTojstring(env,cipher);
    jstring jstr ;
    jstr = CStr2Jstring(env,cipher);

//    (*env)->ReleaseStringUTFChars(env,string, s);
//return  (*env)->NewStringUTF(env, p);
//    return cipher;
    return jstr;
//    return (*env)->CStr2Jstring(env,p);
}


