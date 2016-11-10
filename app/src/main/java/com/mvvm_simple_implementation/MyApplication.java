package com.mvvm_simple_implementation;

import android.app.Application;

import com.mvvm_simple_implementation.dagger.component.DaggerNetworkComponent;
import com.mvvm_simple_implementation.dagger.component.NetworkComponent;
import com.mvvm_simple_implementation.dagger.module.AppModule;
import com.mvvm_simple_implementation.dagger.module.NetworkModule;

/**
 * Created by yadu on 10/11/16.
 */

public class MyApplication extends Application{
    private NetworkComponent networkComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        networkComponent = DaggerNetworkComponent.builder()
                .appModule(new AppModule(this))
                .networkModule(new NetworkModule("http://reqres.in/"))
                .build();
    }

    public NetworkComponent getNetworkComponent() {
        return networkComponent;
    }
}
