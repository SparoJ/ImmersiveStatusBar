package com.pingan.apple.immersivestatusbar;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.pingan.apple.immersivestatusbar.listviewfunction.ListViewFunctionActivity;
import com.pingan.apple.immersivestatusbar.progressview.ProgressViewActivity;
import com.pingan.apple.immersivestatusbar.recyclerviewdemo.complexdemo.ComplexActivity;
import com.pingan.apple.immersivestatusbar.recyclerviewdemo.headfootitem.HeadFootItemActivity;
import com.pingan.apple.immersivestatusbar.recyclerviewdemo.pinestickview.PineStickActivity;
import com.pingan.apple.immersivestatusbar.staticview.StaticsViewActivity;

/**
 * @author apple
 * @Description :
 * @date 17/1/11  上午10:54
 */

public class SelfDefineEntranceActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtnStaticsView;
    private Button mBtnCircleProgressView;
    private Button mBtnListViewEdit;
    private Button mBtnRecyclerView;
    private Button mBtnRecyclerHeadFootItem;
    private Button mBtnRecyclerPineStick;

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

        mBtnListViewEdit = (Button) findViewById(R.id.btn_listview_edittext);
        mBtnListViewEdit.setOnClickListener(this);

        mBtnRecyclerView = (Button) findViewById(R.id.btn_recyclerView_function);
        mBtnRecyclerView.setOnClickListener(this);

        mBtnRecyclerHeadFootItem = (Button) findViewById(R.id.btn_recyclerView_head_foot);
        mBtnRecyclerHeadFootItem.setOnClickListener(this);

        mBtnRecyclerPineStick = (Button) findViewById(R.id.btn_recyclerView_pine_stick);
        mBtnRecyclerPineStick.setOnClickListener(this);


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
            case R.id.btn_listview_edittext :
                intent.setClass(SelfDefineEntranceActivity.this, ListViewFunctionActivity.class);
                break;
            case R.id.btn_recyclerView_function :
                intent.setClass(SelfDefineEntranceActivity.this, ComplexActivity.class);
                break;
            case R.id.btn_recyclerView_head_foot :
                intent.setClass(SelfDefineEntranceActivity.this, HeadFootItemActivity.class);
                break;
            case R.id.btn_recyclerView_pine_stick :
                intent.setClass(SelfDefineEntranceActivity.this, PineStickActivity.class);
                break;
            //btn_listview_edittext
        }
        startActivity(intent);
    }
}
