package com.zuga.log;

import android.util.Log;

/**
 * Saqrag
 */

@SuppressWarnings("WeakerAccess")
public class LogSa {

    public final static boolean LOGV = true;
    public final static boolean LOGD = true;
    public final static boolean LOGI = true;
    public final static boolean LOGW = true;
    public final static boolean LOGE = true;

    public static void v(String format, Object... args) {
        if (LOGV) {
            Log.v(getTag(), String.format(format, args));
        }
    }

    public static void d(String format, Object... args) {
        if (LOGD) {
            Log.d(getTag(), String.format(format, args));
        }
    }

    public static void i(String format, Object... args) {
        if (LOGI) {
            Log.i(getTag(), String.format(format, args));
        }
    }

    public static void w(String format, Object... args) {
        if (LOGW) {
            Log.w(getTag(), String.format(format, args));
        }
    }

    public static void e(String format, Object... args) {
        if (LOGE) {
            Log.e(getTag(), String.format(format, args));
        }
    }

    private static String getTag() {
        StackTraceElement[] trace = new Throwable().fillInStackTrace().getStackTrace();
        String callingClass = "";
        for (int i = 2; i < trace.length; i++) {
            Class<?> clazz = trace[i].getClass();
            if (!clazz.equals(LogSa.class)) {
                callingClass = trace[i].getClassName();
                callingClass = callingClass.substring(callingClass.lastIndexOf('.') + 1);
                break;
            }
        }
        return callingClass;
    }
}
