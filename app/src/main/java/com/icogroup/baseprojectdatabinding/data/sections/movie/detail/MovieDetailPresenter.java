package com.icogroup.baseprojectdatabinding.data.sections.movie.detail;

import com.icogroup.baseprojectdatabinding.data.model.Movie;

/**
 * Created by Ulises.harris on 6/1/16.
 */
public class MovieDetailPresenter implements MovieDetailContract.MovieDetailActionListener,
        MovieDetailProvider.MovieDetailOutput {

    private MovieDetailContract.View mView;
    private MovieDetailInteractor mInteractor;

    public MovieDetailPresenter(MovieDetailContract.View view) {

        this.mView = view;

        mInteractor = new MovieDetailInteractor(this);
    }

    @Override
    public void getMovie(String id) {
        if(mView != null)
            mInteractor.getMovie(id);
    }

    @Override
    public void onDestroy() {
        mView = null;
    }

    @Override
    public void setMovie(Movie movie) {
        mView.setMovie(movie);
    }

    @Override
    public void setError(String error) {
        mView.showError(error);
    }
}
