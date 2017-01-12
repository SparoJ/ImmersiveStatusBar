package com.pingan.apple.immersivestatusbar.staticview;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.pingan.apple.immersivestatusbar.R;

/**
 * @author apple
 * @Description :
 * @date 17/1/11  上午10:54
 */

public class SelfDefineEntranceActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtnStaticsView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_self_define_entrance);
        process();
    }

    private void process() {
        mBtnStaticsView = (Button) findViewById(R.id.btn_statics_view);
        mBtnStaticsView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_statics_view :
                Intent intent = new Intent();
                intent.setClass(SelfDefineEntranceActivity.this, StaticsViewActivity.class);
                startActivity(intent);
                break;

        }
    }
}
