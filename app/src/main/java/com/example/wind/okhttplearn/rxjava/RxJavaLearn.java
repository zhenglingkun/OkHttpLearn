package com.example.wind.okhttplearn.rxjava;

import android.util.Log;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;
import rx.functions.Func2;

/**
 * @author zlk
 * @time 2016/6/24.
 */
public class RxJavaLearn {

    public void allOperator() {
        Observable<Boolean> ob = Observable.just(10).all(new Func1<Integer, Boolean>() {
            @Override
            public Boolean call(Integer integer) {
                return integer > 9;
            }
        });

        ob.subscribe(new Subscriber<Boolean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                Log.wtf("ob", "onError: ", e);
            }

            @Override
            public void onNext(Boolean aBoolean) {
                Log.i("ob", "onNext: is true ? " + aBoolean);
            }
        });

        Observable<Boolean> ob1 = Observable.just(8).all(new Func1<Integer, Boolean>() {
            @Override
            public Boolean call(Integer integer) {
                return integer < 10;
            }
        });

        ob1.subscribe(new Subscriber<Boolean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                Log.wtf("ob1", "onError: ", e);
            }

            @Override
            public void onNext(Boolean aBoolean) {
                Log.i("ob1", "onNext: is true ? " + aBoolean);

            }
        });

        Observable.zip(ob1, ob, new Func2<Boolean, Boolean, String>() {
            @Override
            public String call(Boolean aBoolean, Boolean aBoolean2) {
                return aBoolean && aBoolean ? "true" : "false";
            }
        }).subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                Log.wtf("zip", "onError: ", e);
            }

            @Override
            public void onNext(String s) {
                Log.i("zip", "onNext: s = " + s);
            }
        });

    }

}
