package com.mvvm_simple_implementation.dagger.views;

import android.content.Context;

import com.mvvm_simple_implementation.model.Datum;

import java.util.List;

/**
 * Created by yadu on 10/11/16.
 */

public interface MainScreenView {
    Context getContext();

    void loadData(List<Datum> datumList);
}
