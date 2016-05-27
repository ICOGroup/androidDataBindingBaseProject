package com.icogroup.baseprojectdatabinding.ui.viewHolder;

import com.icogroup.baseprojectdatabinding.data.base.RecyclerViewBaseViewHolder;
import com.icogroup.baseprojectdatabinding.data.model.Movie;
import com.icogroup.baseprojectdatabinding.databinding.MovieItemBinding;

/**
 * Created by Ulises.harris on 5/27/16.
 */
public class MovieViewHolder extends RecyclerViewBaseViewHolder<Movie, MovieItemBinding> {


    private final MovieItemBinding mBinding;

    public MovieViewHolder(MovieItemBinding binding) {
        super(binding);
        mBinding = binding;
    }

    @Override
    protected void bindTo(Movie item) {
        mBinding.setMovie(item);
        mBinding.executePendingBindings();
    }
}
