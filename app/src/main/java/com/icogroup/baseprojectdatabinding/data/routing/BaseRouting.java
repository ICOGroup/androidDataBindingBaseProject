package com.icogroup.baseprojectdatabinding.data.routing;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.icogroup.baseprojectdatabinding.data.model.Movie;
import com.icogroup.baseprojectdatabinding.ui.activity.MovieDetailActivity;

/**
 * Created by Ulises.harris on 4/29/16.
 */
public class BaseRouting implements IRouting{

    @Override
    public void movieDetail(Activity activity, Context context, Movie movie) {
        Intent intent = new Intent(context, MovieDetailActivity.class);
        intent.putExtra(MovieDetailActivity.MOVIE_EXTRA, movie);
        activity.startActivity(intent);
    }

}
