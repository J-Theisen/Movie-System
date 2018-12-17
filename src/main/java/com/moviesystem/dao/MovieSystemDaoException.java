
package com.moviesystem.dao;

public class MovieSystemDaoException extends Exception {
    
    public MovieSystemDaoException(String message){
        super(message);
    }
    
    public MovieSystemDaoException(String message, Throwable cause){
        super(message, cause);
    }
    
}
