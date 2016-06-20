package com.example.wind.okhttplearn.data;

import com.example.wind.okhttplearn.data.model.Contributor;
import com.example.wind.okhttplearn.data.model.DecryptKey;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by zlk on 2016/6/17.
 */
public interface GitHubClient {
    @GET("/repos/{owner}/{repo}/contributors")
    Observable<List<Contributor>> contributors(
            @Path("owner") String owner,
            @Path("repo") String repo
    );

    @POST("decryptKey.do")
    Observable<DecryptKey> decryptKey();
}
