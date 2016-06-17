package com.example.wind.okhttplearn;

import android.os.Bundle;
import android.os.HandlerThread;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.wind.okhttplearn.data.Contributor;
import com.example.wind.okhttplearn.data.GitHubClient;
import com.example.wind.okhttplearn.data.ServiceGenerator;

import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GitHubClient client = ServiceGenerator.createService(GitHubClient.class);
        HandlerThread handle = new HandlerThread("abc");
        handle.start();
        client.contributors("fs_opensource", "android-boilerplate")
                .subscribeOn(AndroidSchedulers.from(handle.getLooper()))
        .subscribe(new Subscriber<List<Contributor>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                Log.wtf(TAG, "onError: ", e);
            }

            @Override
            public void onNext(List<Contributor> contributors) {
                if (null != contributors) {
                    for (Contributor contributor : contributors) {
                        Log.i(TAG, contributor.login + " (" + contributor.contributions + ")");
                    }
                }
            }
        });

//        Observable.create(new Observable.OnSubscribe<List<Contributor>>() {
//            @Override
//            public void call(Subscriber<? super List<Contributor>> subscriber) {
//                try {
//                    subscriber.onNext(call.execute().body());
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }).observeOn(Schedulers.io())
//        .subscribeOn(AndroidSchedulers.mainThread())
//        .subscribe(new Subscriber<List<Contributor>>() {
//            @Override
//            public void onCompleted() {
//
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                Log.wtf(TAG, "onError: ", e);
//            }
//
//            @Override
//            public void onNext(List<Contributor> contributors) {
//                for (Contributor contributor : contributors) {
//                    Log.i(TAG, contributor.login + " (" + contributor.contributions + ")");
//                }
//            }
//        });

//        String[] names = new String[] {"Lucy", "Lily", "Tom", "Dive"};
//        Observable.from(names).subscribe(new Subscriber<String>() {
//            @Override
//            public void onCompleted() {
//                Log.d(TAG, "onCompleted: ");
//            }
//
//            @Override
//            public void onError(Throwable e) {
//
//            }
//
//            @Override
//            public void onNext(String s) {
//                Log.d(TAG, "onNext: s = " + s);
//            }
//        });

    }
}
