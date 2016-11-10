package com.mvvm_simple_implementation.viewModel;

import android.content.Context;
import android.databinding.BaseObservable;

import com.mvvm_simple_implementation.model.Datum;

/**
 * Created by yadu on 10/11/16.
 */

public class ItemViewModel extends BaseObservable {
    private Datum datum;
    private Context context;

    public ItemViewModel(Datum datum, Context context) {
        this.datum = datum;
        this.context = context;
    }

    public void setDatum(Datum datum) {
        this.datum = datum;
    }

    public String getName(){
        return datum.getName();
    }
    public String getYear(){
        return datum.getYear().toString();
    }
}
