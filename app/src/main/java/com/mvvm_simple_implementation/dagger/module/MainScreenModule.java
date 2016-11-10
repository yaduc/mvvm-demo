package com.mvvm_simple_implementation.dagger.module;

import com.mvvm_simple_implementation.dagger.customScope.CustomScope;
import com.mvvm_simple_implementation.dagger.views.MainScreenView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by yadu on 10/11/16.
 */

@Module
public class MainScreenModule {
    private final MainScreenView view;

    public MainScreenModule(MainScreenView view) {
        this.view = view;
    }

    @Provides
    @CustomScope
    public MainScreenView getView() {
        return view;
    }
}
