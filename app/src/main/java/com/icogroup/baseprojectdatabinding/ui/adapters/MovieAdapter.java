package com.icogroup.baseprojectdatabinding.ui.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.icogroup.baseprojectdatabinding.databinding.MovieItemBinding;
import com.icogroup.baseprojectdatabinding.data.model.Movie;

import java.util.List;


/**
 * Created by Ulises.harris on 5/27/16.
 */
public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieHolder> {


    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private List<Movie> mMovies;

    public MovieAdapter(Context context, List<Movie> movies) {
        this.mContext = context;
        this.mMovies = movies;
        mLayoutInflater = (LayoutInflater) context.getSystemService(Context
                .LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public MovieHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return MovieHolder.create(mLayoutInflater, parent);
    }

    @Override
    public void onBindViewHolder(MovieHolder holder, int position) {
        Movie movie = mMovies.get(position);
        holder.bindTo(movie);
    }

    @Override
    public int getItemCount() {
        return mMovies.size();
    }

    public void setMovies(List<Movie> movies){
        this.mMovies = movies;
        notifyDataSetChanged();
    }

    public static class MovieHolder extends RecyclerView.ViewHolder {

        private MovieItemBinding mBinding;

        static MovieHolder create(LayoutInflater inflater, ViewGroup parent) {

            MovieItemBinding binding = MovieItemBinding.inflate(inflater, parent, false);
            return new MovieHolder(binding);
        }

        public MovieHolder(MovieItemBinding binding) {
            super(binding.getRoot());
            mBinding = binding;
        }

        public void bindTo(Movie movie) {
            mBinding.setMovie(movie);
            mBinding.executePendingBindings();
        }
    }
}
