package com.moviesystem;

import com.moviesystem.dao.MovieSystemDao;
import com.moviesystem.dao.MovieSystemDaoFileImpl;
import com.moviesystem.ui.MovieSystemView;
import com.moviesystem.ui.UserIO;
import com.moviesystem.ui.UserIOConsoleImpl;
import com.moviesystem.controller.MovieSystemController;

public class App {

    public static void main(String[] args) {
        UserIO myio = new UserIOConsoleImpl();
        MovieSystemView myView = new MovieSystemView(myio);
        MovieSystemDao myDao = new MovieSystemDaoFileImpl();
        MovieSystemController controller = new MovieSystemController(myDao, myView);
        controller.run();
    }
}
