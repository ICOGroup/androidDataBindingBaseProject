package com.icogroup.baseprojectdatabinding.data.base;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;


/**
 * Created by Ulises.harris on 5/27/16.
 */
public abstract class RecyclerViewBaseViewHolder<T, VD extends ViewDataBinding> extends RecyclerView.ViewHolder {

    private final VD binding;

    protected abstract void bindTo(T item);

    public RecyclerViewBaseViewHolder(VD binding) {
        super(binding.getRoot());
        this.binding = binding;
    }
}
