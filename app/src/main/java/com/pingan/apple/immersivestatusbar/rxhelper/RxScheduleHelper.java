package com.pingan.apple.immersivestatusbar.rxhelper;


import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;



/**
 * @author apple
 * @Description :
 * @date 17/1/23  下午5:19
 */

public class RxScheduleHelper {

    public static <T>Observable.Transformer<T, T>  io_main() {


        return new Observable.Transformer<T, T>() {
            @Override
            public Observable<T> call(Observable<T> observable) {
                return observable.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());

            }
        };
    }
}
