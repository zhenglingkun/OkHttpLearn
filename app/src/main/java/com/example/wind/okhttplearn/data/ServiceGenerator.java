package com.example.wind.okhttplearn.data;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by kun on 2016/6/16.
 */
public class ServiceGenerator {

    public static final String API_BASE_URL = "http://android.kuaichengwuliu.com/";
//    public static final String API_BASE_URL = "https://api.github.com/";

    private static OkHttpClient.Builder mHttpClient = new OkHttpClient.Builder();

    private static Retrofit.Builder mBuilder = new Retrofit.Builder()
            .baseUrl(API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create());

    public static <S> S createService(Class<S> serviceClass) {
        Retrofit retrofit = mBuilder.client(mHttpClient.build()).build();
        return retrofit.create(serviceClass);
    }

}
