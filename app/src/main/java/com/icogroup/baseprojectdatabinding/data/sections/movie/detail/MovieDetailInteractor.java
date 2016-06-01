package com.icogroup.baseprojectdatabinding.data.sections.movie.detail;

import com.icogroup.baseprojectdatabinding.data.connection.repositories.movies.IMovieServices;
import com.icogroup.baseprojectdatabinding.data.connection.repositories.movies.MovieServices;
import com.icogroup.baseprojectdatabinding.data.model.Movie;

/**
 * Created by Ulises.harris on 6/1/16.
 */
public class MovieDetailInteractor implements MovieDetailProvider {

    private final MovieDetailOutput mOutput;
    private final MovieServices mMovieServices;

    public MovieDetailInteractor(MovieDetailOutput output) {
        this.mOutput = output;

        mMovieServices = new MovieServices();
    }

    @Override
    public void getMovie(String id) {
        mMovieServices.getMovie(id, new IMovieServices.MovieDetail() {
            @Override
            public void onGetMovieSuccess(Movie movie) {
                mOutput.setMovie(movie);
            }

            @Override
            public void onGetMovieFailed(String error) {
                mOutput.setError(error);
            }
        });
    }
}
