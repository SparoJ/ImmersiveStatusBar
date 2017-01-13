package com.pingan.apple.immersivestatusbar.utils;

import android.content.Context;
import android.support.annotation.NonNull;

/**
 * @author apple
 * @Description :
 * @date 17/1/12  下午4:22
 */

public class CommonUtil {

    public static int px2dip(int value, @NonNull Context context) {

        float density = context.getResources().getDisplayMetrics().density;

        return (int)(value/density+0.5f);
    }


    public static int dip2px(int value, Context context) {
        float density = context.getResources().getDisplayMetrics().density;

        return (int)(value*density+0.5f);
    }
}
