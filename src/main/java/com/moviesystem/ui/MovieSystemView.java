package com.moviesystem.ui;

import com.moviesystem.dto.Movie;
import java.util.List;

public class MovieSystemView {

    private UserIO io;

    public MovieSystemView(UserIO io) {
        this.io = io;
    }

    public int printMenuAndGetSelection() {
        System.out.println("");
        io.print("Main Menu");
        io.print("1. List Movies");
        io.print("2. Add Movie");
        io.print("3. View Movie");
        io.print("4. Remove Movie");
        io.print("5. Edit Movie");
        io.print("6. Search for a Movie");
        io.print("7. Exit");

        return io.readInt("Please select from the above choices.", 1, 8);
    }
    
    public int printEditMenuAndGetSelection(Movie movie) {
        System.out.println("");
        io.print("Movie to Edit -> " + movie.getTitle());
        io.print("1. Edit Release Date");
        io.print("2. Edit Director");
        io.print("3. Edit Studio");
        io.print("4. Edit MPAA Rating");
        io.print("5. Edit User Rating");
        io.print("6. Exit to Main Menu");
        
        return io.readInt("Please select from the above choices.",1, 7);
    }

    public Movie getNewMovieInfo() {
        String title = io.readString("Please enter the movie title.");
        String releaseDate = io.readString("Please enter the release date.");
        String director = io.readString("Please enter the director.");
        String studio = io.readString("Please enter the studio.");
        String mpaaRating = io.readString("Please enter the MPAA rating.");
        String userRatingNote = io.readString("Please enter your rating/note.");
        return new Movie(title, releaseDate, director, studio, userRatingNote, mpaaRating);
    }

    

    public void displayCreateMovieBanner() {
        System.out.println("");
        io.print("=== Create Movie ===");
    }

    public void displayCreateSuccessBanner() {
        io.print("Movie successfully added.  Please enter any character and press enter to continue.");
    }

    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }

    public void displayAllMoviesBanner() {
        System.out.println("");
        io.print("=== Display All Movies ===");
    }

    public void displayAllMovies(List<String> list) {
        System.out.println("Movies: ");
        for (String s : list) {
            io.print(s);
        }
    }

    public void displayDeleteMovieBanner() {
        System.out.println("");
        io.print("=== Delete Movie ===");
    }

    public String getMovietitle() {
        System.out.println("");
        return io.readString("Please enter the title of the movie.");
    }

    public String getSearchKeyword() {
        System.out.println("");
        return io.readString("Please enter what you'd like to search for (it is a 'starts with' kind of search)");
    }

    public void displayRemoveSuccessBanner() {
        System.out.println("");
        io.print("Movie successfully deleted. Please enter any character and press enter to continue.");
    }

    public void displayMovieInfoBanner() {
        System.out.println("");
        System.out.println("=== Display Movie Info ===");
    }

    public void displayMovieInfo(Movie movie) {
        System.out.println("");
        if (movie != null) {
            io.print("Title: " + movie.getTitle());
            io.print("Release Date: " + movie.getReleaseDate());
            io.print("Director: " + movie.getDirector());
            io.print("Studio: " + movie.getStudio());
            io.print("MPAA Rating: " + movie.getMpaaRating());
            io.print("User Rating: " + movie.getUserRatingNote());
        } else {
            io.print("No such movie exists.");
        }
        io.readString("Please enter any character and hit enter to continue.");
    }

    public void displayMovieSearchBanner() {
        System.out.println("=== Movie Search ===");
    }

    public void displaySearchResults(List<String> movieList, String searchTitle) {
        if (!movieList.isEmpty()) {
            io.print("=== Movies that start with '" + searchTitle + "' ===");
            for (String s : movieList) {
                io.print(s);
            }
        } else {
            io.print("The search yielded no results.");
        }
    }

    public void displayAllMoviesSuccessBanner() {
        System.out.println("");
        io.print("List all movies success. Please enter any character and press enter to continue.");
    }

    public void displayMovieInfoSuccessBanner() {
        System.out.println("");
        io.print("Display movie info success. Please enter any character and press enter to continue.");

    }

    public void displayMovieSearchSuccessBanner() {
        System.out.println("");
        io.print("Movie search success. Please enter any character and press enter to continue.");
    }

    public void displayExitBanner() {
        io.print("The program will now exit. Goodbye!");
    }

    public void displayEditMovieBanner() {
        System.out.println("");
        io.print("=== Edit Movie ===");
    }

    public void displayEditMovieSuccessBanner() {
        io.print("Edit movie success.");
    }
    
    public String getDirector(){
        return io.readString("Enter the new name of the direcor.");
    }
    
    public String getReleaseDate(){
        return io.readString("Enter the new release date.");
    }
    
    public String getStudio(){
        return io.readString("Enter the new studio.");
    }
    
    public String getMpaaRating(){
        return io.readString("Enter the new MPAA rating.");
    }
    
    public String getUserRating(){
        return io.readString("Enter the new user rating.");
    }

}
