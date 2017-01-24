package com.pingan.apple.immersivestatusbar.widget;

import android.graphics.Color;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Button;

import com.jakewharton.rxbinding.view.RxView;
import com.pingan.apple.BaseActivity;
import com.pingan.apple.immersivestatusbar.R;
import com.pingan.apple.immersivestatusbar.movie.TestAdapter;
import com.pingan.apple.immersivestatusbar.movie.bean.MovieTodayEntity;
import com.pingan.apple.immersivestatusbar.network.NetWorks;
import com.pingan.apple.immersivestatusbar.rxhelper.RxScheduleHelper;
import com.pingan.apple.immersivestatusbar.utils.CommonUtil;
import com.pingan.apple.immersivestatusbar.utils.OnDoubleClickListener;
import com.squareup.picasso.Picasso;
import com.trello.rxlifecycle.android.ActivityEvent;

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
    private List<MovieTodayEntity.DataBean.MoviesBean> mListMovie = new ArrayList<>();
    private List<MovieTodayEntity.DataBean.MoviesBean> mRvData = new ArrayList<>();
    private RecyclerView mRvMovieHome;

    private int PAGE_NUM = 10;
    private SwipeRefreshLayout mSrlMovie;

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
        }).compose(this.<String>bindUntilEvent(ActivityEvent.PAUSE))
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


        showMovie();
        mSrlMovie.setColorSchemeColors(Color.RED, Color.BLUE, Color.BLACK);

    }

    private void setRv() {
        CommonUtil.checkIfNull(mListMovie) ;
        int num = PAGE_NUM<mListMovie.size() ? PAGE_NUM : mListMovie.size();
        for (int i = 0; i < num; i++) {
            mRvData.add(mListMovie.get(i));
        }
        TestAdapter adapter = new TestAdapter(this,mListMovie);
        mRvMovieHome.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mRvMovieHome.setAdapter(adapter);
    }

    private void showMovie() {

        /*****movie request through retrofit & rxjava*****/
        NetWorks.getInstance().getMovieApi()  // 获取interface 的动态代理
                .getTodayHomeMovie("hot", 0, 1000)
                .compose(this.<MovieTodayEntity>bindUntilEvent(ActivityEvent.PAUSE))
                .doOnNext(new Action1<MovieTodayEntity>() {
                    @Override
                    public void call(MovieTodayEntity entity) {
                        // do before onNext capture the data
                        Log.e(TAG, "call:thread  of  doOnNext-===== "+Thread.currentThread().getName() );
                    }
                })

                .compose(RxScheduleHelper.<MovieTodayEntity>io_main())
                .subscribe(new Subscriber<MovieTodayEntity>() {
                    @Override
                    public void onCompleted() {
                        Log.e(TAG, "onCompleted: " );
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "onError: "+e );
                    }

                    @Override
                    public void onNext(MovieTodayEntity entity) {
                        Log.e(TAG, "onNext: "+ entity.getControl()+"/n=data="+entity.getData().getMovies());
                        mListMovie = entity.getData().getMovies();
                        Log.e(TAG, "call:thread  of  onNext=====-===== "+Thread.currentThread().getName()+"size/////"+mListMovie.size());
                        setRv();
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

        mRvMovieHome.addOnScrollListener(new RecyclerView.OnScrollListener() {
            Picasso picasso = Picasso.with(RxTestActivity.this);
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                    if(newState == RecyclerView.SCROLL_STATE_IDLE) {

                        picasso.resumeTag("img");
                    }else {
                        picasso.pauseTag("img");
                    }
            }
        });

        mSrlMovie.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

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
        mRvMovieHome = $(R.id.rv_movie);
        mBtnFrom = $(R.id.btn_rx_from);
        mBtnJust = $(R.id.btn_rx_just);
        mSrlMovie = $(R.id.srl_movie);

    }

}
