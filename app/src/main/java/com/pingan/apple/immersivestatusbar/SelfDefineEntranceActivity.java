package com.pingan.apple.immersivestatusbar;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.pingan.apple.immersivestatusbar.progressview.ProgressViewActivity;
import com.pingan.apple.immersivestatusbar.staticview.StaticsViewActivity;

/**
 * @author apple
 * @Description :
 * @date 17/1/11  上午10:54
 */

public class SelfDefineEntranceActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtnStaticsView;
    private Button mBtnCircleProgressView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_self_define_entrance);
        process();
    }

    private void process() {
        mBtnStaticsView = (Button) findViewById(R.id.btn_statics_view);
        mBtnCircleProgressView = (Button) findViewById(R.id.btn_circleProgress_view);
        mBtnStaticsView.setOnClickListener(this);
        mBtnCircleProgressView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.btn_statics_view :
                intent.setClass(SelfDefineEntranceActivity.this, StaticsViewActivity.class);
                break;
            case R.id.btn_circleProgress_view :
                intent.setClass(SelfDefineEntranceActivity.this, ProgressViewActivity.class);
                break;
        }
        startActivity(intent);
    }
}
