package com.icogroup.baseprojectdatabinding.data.sections.movie.detail;

import com.icogroup.baseprojectdatabinding.data.model.Movie;

/**
 * Created by Ulises.harris on 6/1/16.
 */
public interface MovieDetailContract {

    interface View{
        void showError(String error);

        void setMovie(Movie movie);
    }

    interface MovieDetailActionListener{
        void getMovie(String id);

        void onDestroy();
    }
}
