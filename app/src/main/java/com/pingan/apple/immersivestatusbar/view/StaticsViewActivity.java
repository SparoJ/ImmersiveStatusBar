package com.pingan.apple.immersivestatusbar.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.pingan.apple.immersivestatusbar.R;

/**
 * @author apple
 * @Description :
 * @date 17/1/11  上午11:12
 */
public class StaticsViewActivity extends AppCompatActivity{

    private StaticsView mStaticsView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acivity_statics_view);
        process();
    }

    private void process() {
        mStaticsView = (StaticsView) findViewById(R.id.statics_view);
    }

    @Override
    protected void onResume() {
        super.onResume();
        setStaticsNum();
    }

    private void setStaticsNum() {
        mStaticsView.setYValues(new float[]{10, 18, 23, 34.5f, 43.2f, 51.3f, 64.5f});
        mStaticsView.setXString(new String[]{"星期一","星期二","星期三","星期四","星期五","星期六","星期日"});
    }
}
