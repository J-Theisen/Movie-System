package com.moviesystem.dto;

public class Movie {

    private String title;
    private String releaseDate;
    private String director;
    private String studio;
    private String userRatingNote;
    private String mpaaRating;

    //public int id; -> not yet implemented

    public Movie(String title, String releaseDate, String director, String studio, String userRatingNote, String mpaaRating) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.director = director;
        this.studio = studio;
        this.userRatingNote = userRatingNote;
        this.mpaaRating = mpaaRating;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String ReleaseDate) {
        this.releaseDate = ReleaseDate;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getUserRatingNote() {
        return userRatingNote;
    }

    public void setUserRatingNote(String userRatingNote) {
        this.userRatingNote = userRatingNote;
    }

    public String getMpaaRating() {
        return mpaaRating;
    }

    public void setMpaaRating(String mpaaRating) {
        this.mpaaRating = mpaaRating;
    }

    public String getTitle() {
        return title;
    }

}
