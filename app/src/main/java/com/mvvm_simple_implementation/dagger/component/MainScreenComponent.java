package com.mvvm_simple_implementation.dagger.component;

/**
 * Created by yadu on 10/11/16.
 */

import com.mvvm_simple_implementation.dagger.customScope.CustomScope;
import com.mvvm_simple_implementation.dagger.module.MainScreenModule;
import com.mvvm_simple_implementation.view.MainActivity;

import dagger.Component;

@CustomScope
@Component(dependencies = NetworkComponent.class,modules = MainScreenModule.class)
public interface MainScreenComponent {
    void inject(MainActivity mainActivity);
}
