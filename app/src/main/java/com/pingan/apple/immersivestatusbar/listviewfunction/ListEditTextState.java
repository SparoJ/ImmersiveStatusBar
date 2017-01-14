package com.pingan.apple.immersivestatusbar.listviewfunction;


import rx.Observable;
import rx.subjects.PublishSubject;

/**
 * @author apple
 * @Description :
 * @date 17/1/13  上午10:24
 */

public class ListEditTextState<T> {

    /**
     * create private constructor to inhabit initial instance through constructors
     */
    private ListEditTextState() {}

    private static PublishSubject<ListEditTextBean> sStateObservable = PublishSubject.create();

    public static Observable<ListEditTextBean> getObservable() {
        return sStateObservable;
    }

    public static void publish(ListEditTextBean editTextBean) {
        try {
            sStateObservable.onNext(editTextBean);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
