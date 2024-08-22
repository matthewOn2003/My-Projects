package com.cinema_website.backend.model;


//import jakarta.persistence.*;

//import lombok.Data;
import com.cinema_website.backend.dto.MovieDTO;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

//@Data
public class Movie {
    private int movieId;
    private String title;
    private String genre;
    private int duration;
    private String language;
    private String subtitle;
    private String posterImage;
    private String trailerLink;
    private String director;
    private String synopsis;
    private Timestamp releaseDate;
    private Timestamp createdAt;
    private Timestamp updatedAt;



    // Default constructor
    public Movie() {

    }

    public Movie(int movieId, String title, String genre, int duration, String language, String subtitle, String posterImage, String trailerLink, String director, String synopsis, Timestamp releaseDate, Timestamp createdAt, Timestamp updatedAt) {
        this.movieId = movieId;
        this.title = title;
        this.genre = genre;
        this.duration = duration;
        this.language = language;
        this.subtitle = subtitle;
        this.posterImage = posterImage;
        this.trailerLink = trailerLink;
        this.director = director;
        this.synopsis = synopsis;
        this.releaseDate = releaseDate;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getPosterImage() {
        return posterImage;
    }

    public void setPosterImage(String posterImage) {
        this.posterImage = posterImage;
    }

    public String getTrailerLink() {
        return trailerLink;
    }

    public void setTrailerLink(String trailerLink) {
        this.trailerLink = trailerLink;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public Timestamp getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Timestamp releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieId=" + movieId +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", duration=" + duration +
                ", language='" + language + '\'' +
                ", subtitle='" + subtitle + '\'' +
                ", posterImage='" + posterImage + '\'' +
                ", trailerLink='" + trailerLink + '\'' +
                ", director='" + director + '\'' +
                ", synopsis='" + synopsis + '\'' +
                ", releaseDate=" + releaseDate +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
