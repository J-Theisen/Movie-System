package com.moviesystem.dao;

import com.moviesystem.dto.Movie;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MovieSystemDaoFileImpl implements MovieSystemDao {

    private final List<Movie> movies = new ArrayList<>();

    public static final String ROSTER_FILE = "movies.txt";
    public static final String DELIMITER = "::";

    @Override
    public Movie addMovie(Movie movie) throws MovieSystemDaoException {
        Movie newMovie = movie;
        String newMovieTitle = newMovie.getTitle();
        boolean movieIsInList = false;
        for(Movie m : movies){
            if(m.getTitle().equals(newMovieTitle)){
                movieIsInList = true;
                break;
            } else {
                movieIsInList = false;
            }
        }
        if(!movieIsInList){
            movies.add(newMovie);
            writeRoster();
        } else {
            System.out.println("Movie is already in the system.");
        }
        
        return newMovie;
    }

    @Override
    public List<String> getAllMovies() throws MovieSystemDaoException {
        List<String> returnList = new ArrayList<>();
        //loadRoster();
        for (Movie m : movies) {
            returnList.add(m.getTitle());
        }

        return returnList;
    }

    public List<Movie> getAllMovies2() throws MovieSystemDaoException {
        List<Movie> returnList = new ArrayList<>();
        for (Movie m : movies) {
            returnList.add(m);
        }
        return returnList;
    }

    @Override
    public Movie deleteMovie(String title) throws MovieSystemDaoException {
        //might need a if else to see if movie is even in the array list.
        Movie movieToRemove = null;
        for (Movie m : movies) {
            if (m.getTitle().equals(title)) {
                movieToRemove = m;
                movies.remove(m);
                break;
            }
        }
        writeRoster();
        return movieToRemove;
    }

    @Override
    public Movie getMovie(String movieTitle) throws MovieSystemDaoException {
        Movie movieToReturn = null;
        for (Movie m : movies) {
            if (m.getTitle().equals(movieTitle)) {
                movieToReturn = m;
                break;
            }
        }
        return movieToReturn;
    }

    @Override
    public List<String> getMoviesWithSearch(String searchPhrase) throws MovieSystemDaoException {
        List<String> movieSearchList = new ArrayList<>();
        int count = searchPhrase.length();
        for (Movie m : movies) {
            if (m.getTitle().length() >= count) {
                String subString = m.getTitle().substring(0, count);

                if (subString.equals(searchPhrase)) {
                    movieSearchList.add(m.getTitle());
                }

            }
        }
        return movieSearchList;
    }

    @Override
    public void writeRoster() throws MovieSystemDaoException {

        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(ROSTER_FILE));
        } catch (IOException e) {
            throw new MovieSystemDaoException(
                    "Could not save movie data.", e);
        }

        List<Movie> movies = this.getAllMovies2();
        for (Movie currentMovie : movies) {
            // write the Movie object to the file
            out.println(currentMovie.getTitle() + DELIMITER
                    + currentMovie.getReleaseDate() + DELIMITER
                    + currentMovie.getDirector() + DELIMITER
                    + currentMovie.getStudio() + DELIMITER
                    + currentMovie.getMpaaRating() + DELIMITER
                    + currentMovie.getUserRatingNote());
            // force PrintWriter to write line to the file
            out.flush();
        }
        // Clean up
        out.close();
    }

    @Override
    public void loadRoster() throws MovieSystemDaoException {
        Scanner scanner;

        try {
            // Create Scanner for reading the file
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(ROSTER_FILE)));
        } catch (FileNotFoundException e) {
            throw new MovieSystemDaoException("-_- Could not load roster data into memory.", e);
        }
        // currentLine holds the most recent line read from the file
        String currentLine;
        String[] currentTokens;

        while (scanner.hasNextLine()) {
            // get the next line in the file
            currentLine = scanner.nextLine();
            currentTokens = currentLine.split(DELIMITER);
            Movie currentMovie = new Movie(currentTokens[0], currentTokens[1], currentTokens[2], currentTokens[3], currentTokens[5], currentTokens[4]);
            movies.add(currentMovie);
        }
        // close scanner
        scanner.close();
    }
    
    
}
