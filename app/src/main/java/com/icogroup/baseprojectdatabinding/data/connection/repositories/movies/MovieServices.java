package com.icogroup.baseprojectdatabinding.data.connection.repositories.movies;


import com.icogroup.baseprojectdatabinding.data.connection.ServiceHelper;
import com.icogroup.baseprojectdatabinding.data.connection.repositories.RepositoryInterface;
import com.icogroup.baseprojectdatabinding.data.model.Movie;
import com.icogroup.baseprojectdatabinding.data.model.Search;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Ulises.harris on 4/28/16.
 */
public class MovieServices {

    public void searchMovie(String text, final RepositoryInterface<List<Movie>> callback){
        Call<Search> call = ServiceHelper.getMovieInterface().searchMovies(text);
        call.enqueue(new Callback<Search>() {
            @Override
            public void onResponse(Call<Search> call, Response<Search> response) {
                callback.onSuccess(response.body().getSearch());
            }

            @Override
            public void onFailure(Call<Search> call, Throwable t) {
                callback.onFailure(t.getLocalizedMessage());
            }
        });
    }

    public void getMovie(String id, final RepositoryInterface<Movie> callback){
        Call<Movie> call = ServiceHelper.getMovieInterface().gethMovie(id);
        call.enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(Call<Movie> call, Response<Movie> response) {
                callback.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<Movie> call, Throwable t) {
                callback.onFailure(t.getLocalizedMessage());
            }
        });
    }
}
