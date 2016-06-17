package com.icogroup.baseprojectdatabinding.data.sections.movie.detail;

import com.icogroup.baseprojectdatabinding.data.connection.repositories.RepositoryInterface;
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
        mMovieServices.getMovie(id, new RepositoryInterface<Movie>() {
            @Override
            public void onSuccess(Movie item) {
                mOutput.setMovie(item);
            }

            @Override
            public void onFailure(String error) {
                mOutput.setError(error);
            }
        });
    }
}
