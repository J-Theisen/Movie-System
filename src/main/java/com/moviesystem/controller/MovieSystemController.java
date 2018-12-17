package com.moviesystem.controller;

import com.moviesystem.dao.MovieSystemDao;
import com.moviesystem.dao.MovieSystemDaoException;
import com.moviesystem.dto.Movie;
import com.moviesystem.ui.MovieSystemView;
import java.util.List;

public class MovieSystemController {

    MovieSystemDao dao;
    MovieSystemView view;

    public MovieSystemController(MovieSystemDao dao, MovieSystemView view) {
        this.dao = dao;
        this.view = view;
    }

    public void run() {
        boolean keepGoing = true;
        int menuSelection;
        try {
        dao.loadRoster();
            while (keepGoing) {
                menuSelection = getMenuSelection();
                switch (menuSelection) {
                    case 1:
                        displayMovies();
                        break;
                    case 2:
                        createMovie();
                        break;
                    case 3:
                        displayMovieInfo();
                        break;
                    case 4:
                        deleteMovie();
                        break;
                    case 5:
                        editMovie();
                        break;
                    case 6:
                        movieSearch();
                        break;
                    case 7:
                        keepGoing = false;
                        break;
                    default:
                        System.out.println("Unknown command");
                        ;
                }
            }
        } catch (MovieSystemDaoException e) {
            view.displayErrorMessage(e.getMessage());
        }
        exitMessage();
    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    private void createMovie() throws MovieSystemDaoException {
        view.displayCreateMovieBanner();
        Movie movie = view.getNewMovieInfo();
        dao.addMovie(movie);
        view.displayCreateSuccessBanner();
    }

    public void deleteMovie() throws MovieSystemDaoException {
        view.displayDeleteMovieBanner();
        String movieToDelete = view.getMovietitle();
        dao.deleteMovie(movieToDelete);
        view.displayRemoveSuccessBanner();
    }

    public void displayMovies() throws MovieSystemDaoException {
        view.displayAllMoviesBanner();
        List<String> movieList = dao.getAllMovies();
        view.displayAllMovies(movieList);
        view.displayAllMoviesSuccessBanner();
    }

    public void displayMovieInfo() throws MovieSystemDaoException {
        view.displayMovieInfoBanner();
        String movieTitle = view.getMovietitle();
        Movie movie = dao.getMovie(movieTitle);
        view.displayMovieInfo(movie);
        view.displayMovieInfoSuccessBanner();
    }

    public void movieSearch() throws MovieSystemDaoException {
        view.displayMovieSearchBanner();
        String titleToSearch = view.getSearchKeyword();
        List<String> movieList = dao.getMoviesWithSearch(titleToSearch);
        view.displaySearchResults(movieList, titleToSearch);
        view.displayMovieSearchSuccessBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }

    private Movie editMovie() throws MovieSystemDaoException {
        int selection = 0;
        view.displayEditMovieBanner();
        String movieTitle = view.getMovietitle();
        Movie movie = dao.getMovie(movieTitle);
        
        
        
        
        if (movie != null) {
            
            while (selection != 6) {
                selection = view.printEditMenuAndGetSelection(movie);

                switch (selection) {
                    case 1:
                       
                        break;
                    case 2:
                        System.out.println("Edit director.");
                        break;
                    case 3:
                        System.out.println("Edit studio.");
                        break;
                    case 4:
                        System.out.println("Edit MPAA Rating");
                        break;
                    case 5:
                        System.out.println("Edit User Rating");
                        break;
                    case 6:
                        System.out.println("Exit");
                        break;
                    default:
                        System.out.println("Unknown");
                }
            }
        } else {
            System.out.println("Movie to edit was not found.");
        }
        return null;
    }
    
}
