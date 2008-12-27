/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class name_connolly_david_pgs_Render */

#ifndef _Included_name_connolly_david_pgs_Render
#define _Included_name_connolly_david_pgs_Render
#ifdef __cplusplus
extern "C" {
#endif
	/*
	 * Class:     name_connolly_david_pgs_Render
	 * Method:    openSubtitle
	 * Signature: (Ljava/lang/String;)V
	 */
	JNIEXPORT void JNICALL Java_name_connolly_david_pgs_Render_openSubtitle
	(JNIEnv *, jobject, jstring);
	
	/*
	 * Class:     name_connolly_david_pgs_Render
	 * Method:    closeSubtitle
	 * Signature: ()V
	 */
	JNIEXPORT void JNICALL Java_name_connolly_david_pgs_Render_closeSubtitle
	(JNIEnv *, jobject);
	
	/*
	 * Class:     name_connolly_david_pgs_Render
	 * Method:    getEventCount
	 * Signature: ()I
	 */
	JNIEXPORT jint JNICALL Java_name_connolly_david_pgs_Render_getEventCount
	(JNIEnv *, jobject);
	
	/*
	 * Class:     name_connolly_david_pgs_Render
	 * Method:    nextEvent
	 * Signature: (I)J
	 */
	JNIEXPORT jobject JNICALL Java_name_connolly_david_pgs_Render_getEventDuration
	(JNIEnv * env, jobject obj, jint event);
	
	/*
	 * Class:     name_connolly_david_pgs_Render
	 * Method:    render
	 * Signature: (J)V
	 */
	JNIEXPORT void JNICALL Java_name_connolly_david_pgs_Render_render
	(JNIEnv *, jobject, jobject, jlong);
	
#ifdef __cplusplus
}
#endif
#endif
