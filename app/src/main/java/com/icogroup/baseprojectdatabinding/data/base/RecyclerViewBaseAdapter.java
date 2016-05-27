package com.icogroup.baseprojectdatabinding.data.base;

import android.content.Context;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ulises.harris on 5/27/16.
 */
public abstract class RecyclerViewBaseAdapter<T, VH extends RecyclerViewBaseViewHolder, VD
        extends ViewDataBinding> extends RecyclerView.Adapter<VH> {

    private LayoutInflater mLayoutInflater;
    protected List<T> list = new ArrayList<>();

    private final Context context;

    public RecyclerViewBaseAdapter(Context context) {
        super();
        this.context = context;
        mLayoutInflater = (LayoutInflater) context.getSystemService(Context
                .LAYOUT_INFLATER_SERVICE);
    }

    protected abstract VH onCreateItemView(LayoutInflater inflater, ViewGroup parent);

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        return onCreateItemView(mLayoutInflater, parent);
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {
        final RecyclerViewBaseViewHolder<T, VD> viewHolder = (RecyclerViewBaseViewHolder<T, VD>) holder;
        final T t = list.get(position);
        viewHolder.bindTo(t);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void add(T item) {
        list.add(item);
        notifyDataSetChanged();
    }

    public void addAll(List<T> data) {
        list.addAll(data);
        notifyDataSetChanged();
    }

    public void setAll(List<T> data) {
        clear();
        list.addAll(data);
        notifyDataSetChanged();
    }

    public List<T> getAll() {
        return list;
    }

    public void clear() {
        list.clear();
    }
}
