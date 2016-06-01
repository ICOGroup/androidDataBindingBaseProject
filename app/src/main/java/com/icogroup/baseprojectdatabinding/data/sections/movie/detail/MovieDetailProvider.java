package com.icogroup.baseprojectdatabinding.data.sections.movie.detail;

import com.icogroup.baseprojectdatabinding.data.model.Movie;

/**
 * Created by Ulises.harris on 6/1/16.
 */
public interface MovieDetailProvider {

    void getMovie(String id);

    interface MovieDetailOutput{
        void setMovie(Movie movie);

        void setError(String error);
    }
}
