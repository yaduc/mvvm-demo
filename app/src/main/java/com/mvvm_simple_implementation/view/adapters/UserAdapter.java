package com.mvvm_simple_implementation.view.adapters;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.mvvm_simple_implementation.R;
import com.mvvm_simple_implementation.databinding.UserListItemBinding;
import com.mvvm_simple_implementation.model.Datum;
import com.mvvm_simple_implementation.viewModel.ItemViewModel;

import java.util.Collections;
import java.util.List;

/**
 * Created by yadu on 10/11/16.
 */

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.PeopleAdapterViewHolder> {

    private List<Datum> datumList;

    public UserAdapter() {
        this.datumList = Collections.emptyList();
    }

    @Override
    public PeopleAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        UserListItemBinding userListItemBinding =
                DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.user_list_item,
                        parent, false);
        return new PeopleAdapterViewHolder(userListItemBinding);
    }

    @Override
    public void onBindViewHolder(PeopleAdapterViewHolder holder, int position) {
        holder.bindDatum(datumList.get(position));
    }

    @Override
    public int getItemCount() {
        return datumList.size();
    }

    public void setDatumList(List<Datum> datumList) {
        this.datumList = datumList;
        notifyDataSetChanged();
    }

    public static class PeopleAdapterViewHolder extends RecyclerView.ViewHolder {
        UserListItemBinding userListItemBinding;

        public PeopleAdapterViewHolder(UserListItemBinding userListItemBinding) {
            super(userListItemBinding.itemUser);
            this.userListItemBinding = userListItemBinding;
        }

        void bindDatum(Datum datum) {
            if (userListItemBinding.getUserViewModel() == null) {
                userListItemBinding.setUserViewModel(
                        new ItemViewModel(datum, itemView.getContext()));
            } else {
                userListItemBinding.getUserViewModel().setDatum(datum);
            }
        }
    }
}
