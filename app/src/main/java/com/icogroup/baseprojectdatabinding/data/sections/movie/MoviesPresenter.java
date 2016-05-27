package com.icogroup.baseprojectdatabinding.data.sections.movie;

import com.icogroup.baseprojectdatabinding.data.connection.repositories.movies.IMovieServices;
import com.icogroup.baseprojectdatabinding.data.connection.repositories.movies.MovieServices;
import com.icogroup.baseprojectdatabinding.data.model.Movie;

import java.util.List;

/**
 * Created by Ulises.harris on 4/29/16.
 */
public class MoviesPresenter implements MoviesContract.MovieActionListener, IMovieServices {

    MovieServices mMovieServices;
    MoviesContract.View mView;

    public MoviesPresenter(MoviesContract.View view) {
        mView = view;

        mMovieServices = new MovieServices(this);
    }

    @Override
    public void getMovies(String text) {
        mMovieServices.searchMovie(text);
    }

    @Override
    public void openMovieDetail(Movie movie) {
        mView.openMovieDetail(movie);
    }

    @Override
    public void onGetMoviesSuccess(List<Movie> movies) {
        mView.showMovies(movies);
    }

    @Override
    public void onGetMoviesFailed(String error) {
        mView.showErrors(error);
    }
}
