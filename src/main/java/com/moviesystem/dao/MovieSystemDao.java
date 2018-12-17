package com.moviesystem.dao;

import com.moviesystem.dto.Movie;
import java.util.List;

public interface MovieSystemDao {

    /** Adds a movie and all its attributes to the collection that
     * is being used.
     * 
     * @param movie movie to be added to the collection.
     * @throws com.moviesystem.dao.MovieSystemDaoException
     */
    Movie addMovie(Movie movie) throws MovieSystemDaoException;
    
    List<String> getAllMovies() throws MovieSystemDaoException;
    
    Movie deleteMovie(String title) throws MovieSystemDaoException;

    Movie getMovie(String movieTitle) throws MovieSystemDaoException;

    List<String> getMoviesWithSearch(String title) throws MovieSystemDaoException;

    void loadRoster() throws MovieSystemDaoException;
    
    void writeRoster() throws MovieSystemDaoException;
    

}
