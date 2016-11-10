package com.mvvm_simple_implementation.view;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.mvvm_simple_implementation.MyApplication;
import com.mvvm_simple_implementation.R;
import com.mvvm_simple_implementation.dagger.component.DaggerMainScreenComponent;
import com.mvvm_simple_implementation.dagger.module.MainScreenModule;
import com.mvvm_simple_implementation.dagger.views.MainScreenView;
import com.mvvm_simple_implementation.databinding.ActivityMainBinding;
import com.mvvm_simple_implementation.model.Datum;
import com.mvvm_simple_implementation.view.adapters.UserAdapter;
import com.mvvm_simple_implementation.viewModel.UserModel;

import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainScreenView {

    private ActivityMainBinding activityMainBinding;

    @Inject
    UserModel userModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaggerMainScreenComponent.builder().networkComponent(((MyApplication)getApplicationContext()).getNetworkComponent())
                .mainScreenModule(new MainScreenModule(this))
                .build().inject(this);
        initBinding();
        userModel.setContext(this);
        setupUserView(activityMainBinding.mRecyclerView);
    }

    private void setupUserView(RecyclerView recyclerView) {
        UserAdapter adapter = new UserAdapter();
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void initBinding() {
        activityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        activityMainBinding.setMainViewModel(userModel);
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void loadData(List<Datum> datumList) {
        UserAdapter peopleAdapter = (UserAdapter) activityMainBinding.mRecyclerView.getAdapter();
        peopleAdapter.setDatumList(datumList);
    }
}
