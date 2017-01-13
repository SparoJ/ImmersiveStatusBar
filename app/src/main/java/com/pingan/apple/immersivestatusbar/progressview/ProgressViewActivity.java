package com.pingan.apple.immersivestatusbar.progressview;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.pingan.apple.immersivestatusbar.R;

/**
 * @author apple
 * @Description :
 * @date 17/1/12  下午3:54
 */

public class ProgressViewActivity extends AppCompatActivity {

    private CircleProgressView mCircleProgressView;
    private static final int STATE_RUNNING = 0;
    private static final int STATE_STOP = 1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_view);
        process();
    }

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {

            int progress = mCircleProgressView.getProgress();
            mCircleProgressView.setProgress(++progress);
            if(progress >=100) {
                mCircleProgressView.setState(CircleProgressView.State.Stop);
                removeMessages(STATE_RUNNING);
                progress = 0;
               mCircleProgressView.setProgress(0);
            } else {
                // 模拟 progress 每隔100ms ++progress
                sendEmptyMessageDelayed(STATE_RUNNING, 100);
            }
        }
    };

    private void process() {
        mCircleProgressView = (CircleProgressView) findViewById(R.id.circle_progress_view);
        mCircleProgressView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mCircleProgressView.getState() == CircleProgressView.State.Stop) {
                   mCircleProgressView.setState(CircleProgressView.State.Running);
                    mHandler.sendEmptyMessage(STATE_RUNNING);
                } else {
                    mCircleProgressView.setState(CircleProgressView.State.Stop);
                    mHandler.removeMessages(STATE_RUNNING);
                }
            }
        });
    }
}
