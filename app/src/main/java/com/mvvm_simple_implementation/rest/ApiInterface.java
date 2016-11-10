package com.mvvm_simple_implementation.rest;

import com.mvvm_simple_implementation.model.Model1;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by yadu on 10/11/16.
 */

public interface ApiInterface {
    @GET("/api/unknown")
    Observable<Model1> getPostList();
}
