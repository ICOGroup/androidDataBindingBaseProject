package com.icogroup.baseprojectdatabinding.data.sections.movie;


import com.icogroup.baseprojectdatabinding.data.connection.repositories.RepositoryInterface;
import com.icogroup.baseprojectdatabinding.data.connection.repositories.movies.MovieServices;
import com.icogroup.baseprojectdatabinding.data.model.Movie;

import java.util.List;

/**
 * Created by Ulises.harris on 6/1/16.
 */
public class MoviesInteractor implements MoviesProvider {

    private MoviesDataOutput mOutput;
    private MovieServices mMovieServices;

    public MoviesInteractor(MoviesDataOutput output) {
        this.mOutput = output;

        mMovieServices = new MovieServices();
    }

    @Override
    public void getMovies(String search) {

        mMovieServices.searchMovie(search, new RepositoryInterface<List<Movie>>() {
            @Override
            public void onSuccess(List<Movie> item) {
                mOutput.setMovies(item);
            }

            @Override
            public void onFailure(String error) {
                mOutput.setError(error);
            }
        });
    }

}
