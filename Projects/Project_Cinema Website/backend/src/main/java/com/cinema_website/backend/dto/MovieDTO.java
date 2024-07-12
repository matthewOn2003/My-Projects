package com.cinema_website.backend.dto;

@SuppressWarnings("all")
public class MovieDTO {
    private int movieId;
    private String title;
    private String genre;
    private String duration;
    private String language;
    private String subtitle;
    private String posterImage;
    private String director;
    private String synopsis;
    private String releaseDate;
    private String createdAt;
    private String updatedAt;



    // Default constructor
    public MovieDTO() {

    }

    public MovieDTO(int movieId, String title, String genre, String duration,
                    String language, String subtitle, String posterImage, String director,
                    String synopsis, String releaseDate, String createdAt, String updatedAt) {
        this.movieId = movieId;
        this.title = title;
        this.genre = genre;
        this.duration = duration;
        this.language = language;
        this.subtitle = subtitle;
        this.posterImage = posterImage;
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

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
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

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
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
                ", director='" + director + '\'' +
                ", synopsis='" + synopsis + '\'' +
                ", releaseDate=" + releaseDate +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
