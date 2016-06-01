package com.icogroup.baseprojectdatabinding.data.sections.movie;


import com.icogroup.baseprojectdatabinding.data.connection.repositories.movies.IMovieServices;
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

        mMovieServices.searchMovie(search, new IMovieServices.Movies() {
            @Override
            public void onGetMoviesSuccess(List<Movie> movies) {
                mOutput.setMovies(movies);
            }

            @Override
            public void onGetMoviesFailed(String error) {
                mOutput.setError(error);
            }
        });
    }

}
