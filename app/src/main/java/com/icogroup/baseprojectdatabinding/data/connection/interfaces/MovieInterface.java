package com.icogroup.baseprojectdatabinding.data.connection.interfaces;


import com.icogroup.baseprojectdatabinding.data.model.Movie;
import com.icogroup.baseprojectdatabinding.data.model.Search;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Ulises.harris on 4/28/16.
 */
public interface MovieInterface {

    @GET("/")
    Call<Search> searchMovies(@Query("s") String search);

    @GET("/?plot=full")
    Call<Movie> gethMovie(@Query("i") String id);
}
