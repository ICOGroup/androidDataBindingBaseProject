package com.icogroup.baseprojectdatabinding.data.connection.repositories.movies;



import com.icogroup.baseprojectdatabinding.data.model.Movie;

import java.util.List;

/**
 * Created by Ulises.harris on 4/29/16.
 */
public interface IMovieServices {

    interface Movies{

        void onGetMoviesSuccess(List<Movie> movies);

        void onGetMoviesFailed(String error);
    }


    interface MovieDetail{

        void onGetMovieSuccess(Movie movie);

        void onGetMovieFailed(String error);
    }

}
