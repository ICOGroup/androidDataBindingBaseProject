package com.icogroup.baseprojectdatabinding.data.sections.movie;

import com.icogroup.baseprojectdatabinding.data.model.Movie;

import java.util.List;

/**
 * Created by Ulises.harris on 6/1/16.
 */
public interface MoviesProvider {

    void getMovies(String search);

    interface MoviesDataOutput{

        void setMovies(List<Movie> movies);

        void setError(String error);
    }
}
