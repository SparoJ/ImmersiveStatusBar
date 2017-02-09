package com.pingan.apple.immersivestatusbar.utils;

import android.content.Context;
import android.os.Looper;
import android.support.annotation.NonNull;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @author apple
 * @Description :
 * @date 17/1/12  下午4:22
 */

public class CommonUtil {
    public static long mTime ;
    public static long mLastClickTime;
    public static final long TIME = 500;
    public static final String FORMAT_DATE = "yyyy年MM月dd日";
    public static final String FORMAT_SEPERATOR = " ";
    public static final String FORMAT_WEEKDAY = "EEEE";
    public static final String DATE_FORMATER = FORMAT_DATE + FORMAT_SEPERATOR + FORMAT_WEEKDAY;

    public static int px2dip(int value, @NonNull Context context) {

        float density = context.getResources().getDisplayMetrics().density;

        return (int)(value/density+0.5f);
    }


    public static int dip2px(int value, Context context) {
        float density = context.getResources().getDisplayMetrics().density;

        return (int)(value*density+0.5f);
    }
//
//    public static boolean checkDoubleClick() {
//        long currentTime = System.currentTimeMillis();
//        if(currentTime - mTime > TIME) {
//            mTime = currentTime;
//            return false;
//        }
//        mTime = 0;
//        return true;
//    }

    public static boolean checkDoubleClick() {
        long currentTime = System.currentTimeMillis();
        long timeD = currentTime - mLastClickTime;
        if(0<timeD && timeD < TIME) {
            return true; // which means double click happened
        }
        mLastClickTime = currentTime;
        return false;
    }

    /****************precaution check *******************/
    /**check if null**/
    public static <T> T checkIfNull(T value) {
        if(value == null) {
            throw new NullPointerException(value +"== null");
        }
        return value;
    }

    public static <T> T checkIfNull(T value, String msg) {
        if(value == null) {
            throw new NullPointerException(msg);
        }
        return value;
    }



    /**check current thread is the main thread**/
    public static void checkUiThread() {
        if(Looper.getMainLooper() != Looper.myLooper()) {
            throw new IllegalStateException("Must be called from the Main Thread. Current Thread was :"+ Thread.currentThread());
        }
    }

    /****************date convert *******************/
    public static String dateConvertString(Date date) {
        return dateConvertString(date, DATE_FORMATER);
    }

    public static String dateConvertString(Date date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.CHINA);
        return sdf.format(date);
    }
}
