package com.icogroup.baseprojectdatabinding.data.connection.repositories.movies;

import com.icogroup.baseprojectdatabinding.data.model.Movie;

import java.util.List;

/**
 * Created by Ulises.harris on 4/29/16.
 */
public interface IMovieServices {

    void onGetMoviesSuccess(List<Movie> movies);

    void onGetMoviesFailed(String error);
}
