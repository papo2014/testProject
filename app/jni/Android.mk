LOCAL_PATH := $(call my-dir)
include $(CLEAR_VARS)
LOCAL_LDLIBS :=-llog
LOCAL_MODULE := desjni
LOCAL_SRC_FILES := desjni.c 3des.c md5.c
include $(BUILD_SHARED_LIBRARY)