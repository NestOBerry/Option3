#ifndef NATIVEENCRYPTION_NATIVE_LIB_H
#define NATIVEENCRYPTION_NATIVE_LIB_H

#include <jni.h>

#ifdef __cplusplus
extern "C" {
#endif

JNIEXPORT jstring JNICALL
Java_com_example_option3_MainActivity_hashAndEncrypt(JNIEnv *env, jobject, jstring input, jstring publicKey);


#ifdef __cplusplus
}
#endif

#endif //NATIVEENCRYPTION_NATIVE_LIB_H
