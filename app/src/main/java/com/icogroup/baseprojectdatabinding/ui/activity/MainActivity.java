package com.icogroup.baseprojectdatabinding.ui.activity;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.icogroup.baseprojectdatabinding.R;
import com.icogroup.baseprojectdatabinding.data.base.RecyclerViewBaseAdapter;
import com.icogroup.baseprojectdatabinding.data.routing.BaseRouting;
import com.icogroup.baseprojectdatabinding.data.sections.movie.MoviesContract;
import com.icogroup.baseprojectdatabinding.data.sections.movie.MoviesPresenter;
import com.icogroup.baseprojectdatabinding.databinding.ActivityMainBinding;
import com.icogroup.baseprojectdatabinding.data.model.Movie;
import com.icogroup.baseprojectdatabinding.databinding.MovieItemBinding;
import com.icogroup.baseprojectdatabinding.ui.viewHolder.MovieViewHolder;
import com.icogroup.baseprojectdatabinding.util.AppUtil;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MoviesContract.View, SearchView
.OnQueryTextListener{

    private RecyclerView mMovieRecyclerView;
    private ObservableArrayList<Movie> movies;
    private RecyclerViewBaseAdapter<Movie, MovieViewHolder, MovieItemBinding> mMovieAdapter;
    private MoviesContract.MovieActionListener mPresenter;
    private MenuItem searchMenuItem;
    private SearchView mSearchView;
    private BaseRouting mBaseRouting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mPresenter = new MoviesPresenter(this);

        init();

        binding.setMovies(movies);
    }

    private void init() {

        movies = new ObservableArrayList<>();

        mMovieRecyclerView = (RecyclerView) findViewById(R.id.movie_recycler_view);
        mMovieRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mMovieAdapter = new RecyclerViewBaseAdapter<Movie, MovieViewHolder, MovieItemBinding>(this) {
            @Override
            protected MovieViewHolder onCreateItemView(LayoutInflater inflater, ViewGroup parent) {
                MovieItemBinding binding = MovieItemBinding.inflate(inflater, parent, false);
                return new MovieViewHolder(binding);
            }
        };

        mMovieAdapter.setOnItemClickListener(new RecyclerViewBaseAdapter.Listener<Movie>() {
            @Override
            public void onClickItem(Movie movie, View v, int position) {
                mPresenter.openMovieDetail(movie);
            }
        });
        mMovieRecyclerView.setAdapter(mMovieAdapter);
        mBaseRouting = new BaseRouting();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        searchMenuItem = menu.findItem(R.id.action_search);
        mSearchView = (SearchView) searchMenuItem.getActionView();
        mSearchView.setOnQueryTextListener(this);
        return true;

    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {

        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {

        if (query.equals("")) {
            return false;
        } else {
            movies.clear();
            AppUtil.hideKeyboard(this);
            mPresenter.getMovies(query.trim());
            return true;
        }

    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }

    @Override
    public void showMovies(List<Movie> movies) {
        if(movies != null){
            this.movies.clear();
            this.movies.addAll(movies);
            mMovieAdapter.setAll(movies);
        }
    }

    @Override
    public void showDialog() {

    }

    @Override
    public void showErrors(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void openMovieDetail(Movie movie) {
        mBaseRouting.movieDetail(this, this, movie);
    }
}
