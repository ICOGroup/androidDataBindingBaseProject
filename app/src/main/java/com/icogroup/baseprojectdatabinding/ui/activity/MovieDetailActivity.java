package com.icogroup.baseprojectdatabinding.ui.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.icogroup.baseprojectdatabinding.R;
import com.icogroup.baseprojectdatabinding.data.model.Movie;
import com.icogroup.baseprojectdatabinding.data.routing.BaseRouting;
import com.icogroup.baseprojectdatabinding.data.sections.movie.detail.MovieDetailContract;
import com.icogroup.baseprojectdatabinding.data.sections.movie.detail.MovieDetailPresenter;
import com.icogroup.baseprojectdatabinding.databinding.ActivityMovieDetailBinding;

public class MovieDetailActivity extends AppCompatActivity implements MovieDetailContract.View {

    private MovieDetailPresenter mPresenter;
    private Movie mMovie;
    private BaseRouting mBaseRouting;
    public final static String MOVIE_EXTRA = "movie";
    private ActivityMovieDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout
                .activity_movie_detail);

        Intent intent = getIntent();

        Movie movie = new Movie();

        if(intent.hasExtra(MOVIE_EXTRA))
            movie = intent.getParcelableExtra(MOVIE_EXTRA);

        mPresenter = new MovieDetailPresenter(this);

        mMovie = new Movie();
        mBaseRouting = new BaseRouting();

        binding.setMovie(mMovie);

        mPresenter.getMovie(movie.getId());
    }
    @Override
    public void showError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setMovie(Movie movie) {
        mMovie.setId(movie.getId());
        mMovie.setTitle(movie.getTitle());
        mMovie.setActors(movie.getActors());
        mMovie.setAwards(movie.getAwards());
        mMovie.setDirector(movie.getDirector());
        mMovie.setGenre(movie.getGenre());
        mMovie.setImdbRating(movie.getImdbRating());
        mMovie.setImdbVotes(movie.getImdbVotes());
        mMovie.setPlot(movie.getPlot());
        mMovie.setPoster(movie.getPoster());
        mMovie.setRated(movie.getRated());
        mMovie.setReleased(movie.getReleased());
        mMovie.setRuntime(movie.getRuntime());
        mMovie.setWriter(movie.getWriter());
        mMovie.setYear(movie.getYear());
    }
}
