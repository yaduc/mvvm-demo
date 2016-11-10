package com.mvvm_simple_implementation.dagger.component;

import com.mvvm_simple_implementation.dagger.module.AppModule;
import com.mvvm_simple_implementation.dagger.module.NetworkModule;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

/**
 * Created by yadu on 10/11/16.
 */


@Singleton
@Component(modules = {AppModule.class, NetworkModule.class})
public interface NetworkComponent {
    Retrofit retrofit();
}