
package com.moviesystem.ui;

public interface UserIO {
    void print(String msg);
    
    double readDouble(String prompt);
    
    double readDouble(String prompt, double min, double max);

    float readFloat(String prompt);

    float readFloat(String prompt, float min, float max);

    int readInt(String prompt);

    int readInt(String prompt, long min, long max);

    long readLong(String prompt);

    long readLong(String prompt, long min, long max);

    String readString(String prompt);
    
}
