package com.mvvm_simple_implementation.viewModel;

import android.content.Context;
import android.databinding.ObservableInt;
import android.util.Log;
import android.view.View;

import com.mvvm_simple_implementation.dagger.views.MainScreenView;
import com.mvvm_simple_implementation.model.Model1;
import com.mvvm_simple_implementation.rest.ApiInterface;

import javax.inject.Inject;

import retrofit2.Retrofit;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by yadu on 10/11/16.
 */

public class UserModel {
    private MainScreenView mainView;
    private Context context;
    public Retrofit retrofit;

    public ObservableInt progress;

    @Inject
    public UserModel(MainScreenView mainView, Retrofit retrofit) {
        this.mainView = mainView;
        this.retrofit = retrofit;

        progress = new ObservableInt(View.GONE);
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public void onLoadData(View view){
        initializeViews();
        loadUsers();
    }

    private void loadUsers() {
        retrofit.create(ApiInterface.class).getPostList().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .subscribe(new Observer<Model1>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Model1 posts) {
                        progress.set(View.GONE);
                        mainView.loadData(posts.getData());
                    }
                });
    }

    private void initializeViews() {
        progress.set(View.VISIBLE);
    }
}
