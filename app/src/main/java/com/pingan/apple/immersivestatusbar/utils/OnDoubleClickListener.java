package com.pingan.apple.immersivestatusbar.utils;

import android.view.View;



/**
 * @author apple
 * @Description :
 * @date 17/1/20  下午5:56
 */

public abstract class OnDoubleClickListener implements View.OnClickListener {

    private long mTime;
    private final long INTERVAL_TIME = 500;


    @Override
    public void onClick(View v) {
        // 这里实现double 与否的判断
        long currentTime = System.currentTimeMillis();
        if(currentTime - mTime > INTERVAL_TIME ) {
            mTime = currentTime;
            doubleClickGranted();
        }
    }

    protected abstract void doubleClickGranted();
}
