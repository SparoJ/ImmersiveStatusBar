package com.pingan.apple.immersivestatusbar.thirdview;

import java.util.concurrent.TimeUnit;
import android.util.Log;
import android.widget.Button;

import com.jakewharton.rxbinding.view.RxView;
import com.pingan.apple.BaseActivity;
import com.pingan.apple.immersivestatusbar.R;
import com.pingan.apple.immersivestatusbar.utils.OnDoubleClickListener;

import rx.functions.Action1;

/**
 * @author apple
 * @Description :
 * @date 17/1/20  下午3:41
 */

public class RxTestActivity extends BaseActivity {


    private Button mBtnDouble;
    private Button mBtnDebounce;

    @Override
    protected int initPageLayout() {
        return R.layout.activity_rx_test;
    }

    @Override
    protected void process() {
        RxView.clicks(mBtnDouble)
                .throttleFirst(1,TimeUnit.SECONDS)
                .subscribe(new Action1<Void>() {
                    @Override
                    public void call(Void aVoid) {
                        Log.e(TAG, "call: debounce click" );
                    }
                });
    }

    @Override
    protected void initViewListener() {
        // 以前都是在田里用手去干活 有了Rx 靠设备干活
//        mBtnDouble.setOnClickListener(this);
//        mBtnDebounce.setOnClickListener(this);
/**         测试button 的double click check         **/
        mBtnDouble.setOnClickListener(new OnDoubleClickListener() {
            @Override
            protected void doubleClickGranted() {
                Log.e(TAG, "onClick: ==="+"double");
            }
        });

//        mBtnDebounce.setOnClickListener(new OnDoubleClickListener() {
//            @Override
//            protected void doubleClickGranted() {
//                Log.e(TAG, "onClick: ======="+"debounce");
//            }
//        });



    }

    @Override
    protected void initView() {
        mBtnDouble = $(R.id.btn_rx_double_click);
        mBtnDebounce = $(R.id.btn_rx_debounce_click);

    }

}
