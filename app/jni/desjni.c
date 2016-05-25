//
// Created by Administrator on 2016/2/26.
//
#include<stdio.h>
#include<jni.h>
#include"3des.h"

#include "desjni.h"
#include <string.h>
#include<android/log.h>
#include "md5.h"

//#include <windows.h>
#define TAG "myDemo-jni" // 这个是自定义的LOG的标识
#define LOGD(...) __android_log_print(ANDROID_LOG_DEBUG,TAG ,__VA_ARGS__) // 定义LOGD类型
#define LOGI(...) __android_log_print(ANDROID_LOG_INFO,TAG ,__VA_ARGS__) // 定义LOGI类型
#define LOGW(...) __android_log_print(ANDROID_LOG_WARN,TAG ,__VA_ARGS__) // 定义LOGW类型
#define LOGE(...) __android_log_print(ANDROID_LOG_ERROR,TAG ,__VA_ARGS__) // 定义LOGE类型
#define LOGF(...) __android_log_print(ANDROID_LOG_FATAL,TAG ,__VA_ARGS__) // 定义LOGF类型
char key[48+1]={ 'a', '3', 'a', 'c', 'd', '7','9','a', 'b', '3', 'd', 'c', 'd', 'v','9'};

char*   Jstring2CStr(JNIEnv*   env,   jstring   jstr) {
    char *rtn = NULL;
    jclass clsstring = (*env)->FindClass(env,"java/lang/String");
    jstring strencode = (*env)->NewStringUTF(env,"utf-8");
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
    char *data = (char*)malloc(1024);

    strcpy(data, pat);

    jsize len = strlen(data);

    jclass cls = (*env)->FindClass(env,"java/lang/String");
    jstring strcode = (*env)->NewStringUTF(env,"utf-8");

    jmethodID  mid = (*env)->GetMethodID(env,cls, "<init>", "([BLjava/lang/String;)V");
    jbyteArray bArray = (*env)->NewByteArray(env,len);

    (*env)->SetByteArrayRegion(env,bArray, 0, len, (jbyte*)data);

//    env->ReleaseStringUTFChars(env,ip, ips);
//    env->ReleaseStringUTFChars(env,api, apis);
//    env->ReleaseStringUTFChars(env,httptype, type);
//    env->ReleaseStringUTFChars(headerString, strheader);

    return (jstring)(*env)->NewObject(env,cls, mid, bArray, strcode);


//jsize   len   =   strlen(pat);
//
//    jclass   clsstring   =   (*env)->FindClass(env, "java/lang/String");
//    jstring   strencode   =   (*env)->NewStringUTF(env,"utf-8");
//
//    jmethodID   mid   =   (*env)->GetMethodID(env,clsstring,   "<init>",   "([BLjava/lang/String;)V");
//    jbyteArray   barr   =   (*env)-> NewByteArray(env,len);
//
//    (*env)-> SetByteArrayRegion(env,barr,0,len,(jbyte*)pat);
//    return (jstring)(*env)-> NewObject(env,clsstring,mid,barr,strencode);
}
/*
 * Class:     com_pj_test_util_DESTool
 * Method:    l
 * Signature: (Ljava/lang/String;)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_com_pj_test_util_DESTool_decrypt
        (JNIEnv *env, jclass cls, jstring string) {
    char dest16[16+1];
    char  src16[16+1];
//    char result[64];//可以先分配一个足够大的存储空间，根据明文长度来取解密后的消息长度
//    char *rtn = (char*)malloc(1024);
//    memset(dest16,0,sizeof(dest16));
//    memset(key,0,sizeof(key));
//    memset(src16,0,sizeof(src16));
    char *rtn = (char*)malloc(1024);
    rtn =  Jstring2CStr(env,string);
    strcpy(src16,rtn);;
//    LOGI("James Native Function3: %s", rtn);
//    LOGI("James Native Function3: %s", rtn);
//    Decrypt(rtn, key, result, sizeof(rtn));


    LOGI("James Native Function2: %s", src16);
    Do_3DES(src16,key,dest16,'d');
    LOGI("James Native Function2: %s", dest16);
//     LOGI("James Native Function3: %s", result);
    jstring jstr1 ;
//    jstr1 = CStr2Jstring(env,result);
    jstr1 = CStr2Jstring(env,dest16);
    return jstr1;
}

/*
 * Class:     com_pj_test_util_DESTool
 * Method:    a
 * Signature: (Ljava/lang/String;)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_com_pj_test_util_DESTool_encrypt
        (JNIEnv *env, jclass cls, jstring string) {
    unsigned char dest16[16+1];
//    char cipher[64];//可以先分配一个足够大的存储空间存储中间密文结果
    unsigned char src16[16+1];
//    memset(dest16,0,sizeof(dest16));
////    memset(key,0,sizeof(key));
//    memset(src16,0,sizeof(src16));
     char *rtn = (char*)malloc(1024);
    rtn =  Jstring2CStr(env,string);
    strcpy(src16,rtn);
//    memset(dest16,0,sizeof(dest16));
//    memset(key,0,sizeof(key));
//    memset(src16,0,sizeof(src16));

//    LOGI("James Native Function1: %s", rtn);
////    Encrypt(rtn, key, cipher, sizeof(rtn));
    LOGI("James Native Function2: %s", src16);
    Do_3DES(src16,key,dest16,'e');
    LOGI("James Native Function2: %s", dest16);
//    Decrypt(cipher,key,rtn, sizeof(cipher));
//    LOGI("James Native Function3: %s", rtn);
    jstring jstr ;
//    jstr = CStr2Jstring(env,cipher);
//    LOGI("James Native Function4: %s", jstr);
    jstr = CStr2Jstring(env,dest16);
//    LOGI("James Native Function2: %s", jstr);
    return jstr;

}

JNIEXPORT jstring JNICALL Java_com_pj_test_util_DESTool_md5Encrypt
        (JNIEnv *env, jclass cls, jstring string) {
    char* szText = (char*)(*env)->GetStringUTFChars(env, string, 0);

    MD5_CTX context = { 0 };
    MD5Init(&context);
    MD5Update(&context, szText, strlen(szText));
    unsigned char dest[16] = { 0 };
    MD5Final(dest, &context);
    (*env)->ReleaseStringUTFChars(env, string, szText);

    int i = 0;
    char szMd5[32] = { 0 };
    for (i = 0; i < 16; i++)
    {
        sprintf(szMd5, "%s%02x", szMd5, dest[i]);
    }

    return (*env)->NewStringUTF(env, szMd5);
}
