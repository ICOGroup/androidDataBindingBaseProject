package com.icogroup.baseprojectdatabinding.data.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;
import com.icogroup.baseprojectdatabinding.BR;

import java.util.Observable;

/**
 * Created by Ulises.harris on 4/27/16.
 */
public class Movie extends BaseObservable implements Parcelable {

    @SerializedName("Title")
    String title;
    @SerializedName("Year")
    String year;
    @SerializedName("imdbID")
    String id;
    @SerializedName("Type")
    String type;
    @SerializedName("Poster")
    String poster;
    @SerializedName("Rated")
    String rated;
    @SerializedName("Released")
    String released;
    @SerializedName("Runtime")
    String runtime;
    @SerializedName("Genre")
    String genre;
    @SerializedName("Director")
    String director;
    @SerializedName("Writer")
    String writer;
    @SerializedName("Actors")
    String actors;
    @SerializedName("Plot")
    String plot;
    @SerializedName("Awards")
    String awards;
    String imdbRating;
    String imdbVotes;

    public Movie() {
    }

    @Bindable
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        notifyPropertyChanged(BR.title);
    }

    @Bindable
    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
        notifyPropertyChanged(BR.year);
    }

    @Bindable
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
        notifyPropertyChanged(BR.id);
    }

    @Bindable
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
        notifyPropertyChanged(BR.type);
    }

    @Bindable
    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
        notifyPropertyChanged(BR.poster);
    }

    @Bindable
    public String getRated() {
        return rated;
    }

    public void setRated(String rated) {
        this.rated = rated;
        notifyPropertyChanged(BR.rated);
    }

    @Bindable
    public String getReleased() {
        return released;
    }

    public void setReleased(String released) {
        this.released = released;
        notifyPropertyChanged(BR.released);
    }

    @Bindable
    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
        notifyPropertyChanged(BR.runtime);
    }

    @Bindable
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
        notifyPropertyChanged(BR.genre);
    }

    @Bindable
    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
        notifyPropertyChanged(BR.director);
    }

    @Bindable
    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
        notifyPropertyChanged(BR.writer);
    }

    @Bindable
    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
        notifyPropertyChanged(BR.actors);
    }

    @Bindable
    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
        notifyPropertyChanged(BR.plot);
    }

    @Bindable
    public String getAwards() {
        return awards;
    }

    public void setAwards(String awards) {
        this.awards = awards;
        notifyPropertyChanged(BR.awards);
    }

    @Bindable
    public String getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(String imdbRating) {
        this.imdbRating = imdbRating;
        notifyPropertyChanged(BR.imdbRating);
    }

    @Bindable
    public String getImdbVotes() {
        return imdbVotes;
    }

    public void setImdbVotes(String imdbVotes) {
        this.imdbVotes = imdbVotes;
        notifyPropertyChanged(BR.imdbVotes);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(title);
        dest.writeString(year);
        dest.writeString(type);
        dest.writeString(poster);
        dest.writeString(rated);
        dest.writeString(released);
        dest.writeString(runtime);
        dest.writeString(genre);
        dest.writeString(director);
        dest.writeString(writer);
        dest.writeString(actors);
        dest.writeString(plot);
        dest.writeString(awards);
        dest.writeString(imdbRating);
        dest.writeString(imdbVotes);

    }

    public static final Creator<Movie> CREATOR
            = new Creator<Movie>() {
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

    // "De-parcel object
    public Movie(Parcel in) {
        id = in.readString();
        title = in.readString();
        year = in.readString();
        type = in.readString();
        poster = in.readString();
        rated = in.readString();
        released = in.readString();
        runtime = in.readString();
        genre = in.readString();
        director = in.readString();
        writer = in.readString();
        actors = in.readString();
        plot = in.readString();
        awards = in.readString();
        imdbRating = in.readString();
        imdbVotes = in.readString();
    }
}
