package com.imcodebased.androidviewlifecycle;

import android.util.Log;

/**
 * Created by codebased on 19/07/16.
 */
public class LogUtil {

    public final static String TAG = "AndroidViewLifeCycle";

    public static void logSuperStartEntry(Class executingClass) {
        logEntry(executingClass, "SUPER START");
    }

    public static void logSuperStopEntry(Class executingClass) {
        logEntry(executingClass, "SUPER END");
    }


    public static void logEntry(Class executingClass, String message) {

        String className = executingClass.getSimpleName();
        StackTraceElement[] s = Thread.currentThread().getStackTrace();
        String methodName = s[4].getMethodName();

        Log.i(TAG, String.format("%s.%s %s", className, methodName, message));
    }
}
