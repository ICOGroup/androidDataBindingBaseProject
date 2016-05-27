package com.icogroup.baseprojectdatabinding.data.sections.movie;



import com.icogroup.baseprojectdatabinding.data.model.Movie;

import java.util.List;

/**
 * Created by Ulises.harris on 4/28/16.
 */
public interface MoviesContract {

    interface View{
        void showMovies(List<Movie> movies);

        void showDialog();

        void showErrors(String message);

        void openMovieDetail(Movie movie);
    }

    interface MovieActionListener{

        void getMovies(String text);

        void openMovieDetail(Movie movie);
    }
}
