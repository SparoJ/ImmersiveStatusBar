package com.pingan.apple.immersivestatusbar.thirdview;

import android.util.Log;
import android.widget.Button;

import com.jakewharton.rxbinding.view.RxView;
import com.pingan.apple.BaseActivity;
import com.pingan.apple.immersivestatusbar.R;
import com.pingan.apple.immersivestatusbar.utils.OnDoubleClickListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.schedulers.Schedulers;


/**
 * @author apple
 * @Description :
 * @date 17/1/20  下午3:41
 */

public class RxTestActivity extends BaseActivity {


    private Button mBtnDouble;
    private Button mBtnDebounce;
    private Button mBtnFrom;
    private Button mBtnJust;
    private List<String> mList;
    private SimpleDateFormat mSdf = new SimpleDateFormat("yyyy-MM-dd    hh:mm:ss");

    @Override
    protected int initPageLayout() {
        return R.layout.activity_rx_test;
    }

    @Override
    protected void process() {

        initLaunchData();

        RxView.clicks(mBtnDouble)
                .throttleFirst(1,TimeUnit.SECONDS)
                .subscribe(new Action1<Void>() {
                    @Override
                    public void call(Void aVoid) {
                        Log.e(TAG, "call: debounce click" );
                    }
                });

        Observable.from(mList).subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                Log.e(TAG, "call: mList from=="+s);
            }
        });

        Observable.just(mList).subscribe(new Action1<List<String>>() {
            @Override
            public void call(List<String> strings) {
                Log.e(TAG, "call: mList just=="+strings);
            }
        });

        Observable.just(mList.get(0),mList.get(1),mList.get(2)).subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                Log.e(TAG, "call: mList just one by one=="+s );
            }
        });

        Observable.create(new Observable.OnSubscribe<String>() {

            @Override
            public void call(Subscriber<? super String> subscriber) {
                String format = mSdf.format(new Date());
                subscriber.onNext(format);
                Log.e(TAG, "call: normal launch on next action"+ format);
            }
        })
          .doOnNext(new Action1<String>() {
            @Override
            public void call(String s) {

                Log.e(TAG, "call:thread================= "+Thread.currentThread().getName() );
                final String finalS = s;
                //  完成子线程内部创建 外部链式操作中的流不用设置线程而导致ui阻塞
                Schedulers.io().createWorker().schedule(new Action0() {
                    @Override
                    public void call() {
                        Log.e(TAG, "call:createWorker==ThreadName== "+Thread.currentThread().getName()+"// s //"+ finalS);


                        String format = mSdf.format(new Date());
                        try {
                            Log.e(TAG, "doOnNext: format ==="+finalS+"***time***"+format+"||thread||"+Thread.currentThread().getName() );
                            Thread.sleep(3000);
                            String format1 = mSdf.format(new Date());
                            Log.e(TAG, "doOnNext: format sleep for 3 seconds==="+finalS +"***time***"+format1 );
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });



//                s = s+"sleep for 3 before";
//                String format = mSdf.format(new Date());
//                try {
//                    Log.e(TAG, "doOnNext: format ==="+s+"***time***"+format+"||thread||"+Thread.currentThread().getName() );
//                    Thread.sleep(3000);
//                    s = s+"sleep for 3 after";
//                    String format1 = mSdf.format(new Date());
//                    Log.e(TAG, "doOnNext: format sleep for 3 seconds==="+s +"***time***"+format1 );
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
        })
          .observeOn(AndroidSchedulers.mainThread())
          .subscribe(new Observer<String>() {
              @Override
              public void onCompleted() {

              }

              @Override
              public void onError(Throwable e) {

              }

              @Override
              public void onNext(String s) {
                  String format = mSdf.format(new Date());
                  Log.e(TAG, "onNext: capture on next data ==="+ s+"***time***"+format+"||thread||"+Thread.currentThread().getName());
                  mBtnDouble.setText("Rx onNext delay Change");
              }
          });

    }

    private void initLaunchData() {
        mList = new ArrayList<>();
        mList.add("Sara");
        mList.add("Bela");
        mList.add("Cora");

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
        mBtnFrom = $(R.id.btn_rx_from);
        mBtnJust = $(R.id.btn_rx_just);

    }

}
