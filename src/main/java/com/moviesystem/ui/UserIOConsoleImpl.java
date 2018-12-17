package com.moviesystem.ui;

import java.util.Scanner;

public class UserIOConsoleImpl implements UserIO {

    public static Scanner scanner = new Scanner(System.in);

    @Override
    public void print(String msg) {
        System.out.println(msg);
    }

    @Override
    public double readDouble(String prompt) {
        System.out.println(prompt);
        String returnDoubleString;
        double returnDouble;
        while (true) {
            returnDoubleString = scanner.next();
            if (validEntry(returnDoubleString)) {
                returnDouble = Double.parseDouble(returnDoubleString);
                break;
            }
        }
        return returnDouble;
    }

    @Override
    public double readDouble(String prompt, double min, double max) {
        System.out.println(prompt);
        String returnDoubleString;
        double returnDouble;
        while (true) {
            returnDoubleString = scanner.next();
            if (validEntry(returnDoubleString)) {
                returnDouble = Double.parseDouble(returnDoubleString);
                if (returnDouble >= min && returnDouble <= max) {
                    break;
                } else {
                    System.out.format("%.2f is not a number between %.2f and %.2f. Try again.%n", returnDouble, min, max);
                }
            }
        }
        return returnDouble;
    }

    @Override
    public float readFloat(String prompt) {
        System.out.println(prompt);
        String returnFloatString;
        float returnFloat;
        while (true) {
            returnFloatString = scanner.next();
            if (validEntry(returnFloatString)) {
                returnFloat = Float.parseFloat(returnFloatString);
                break;
            }
        }
        return returnFloat;
    }

    @Override
    public float readFloat(String prompt, float min, float max) {
        System.out.println(prompt);
        String returnFloatString;
        float returnFloat;
        while (true) {
            returnFloatString = scanner.next();
            if (validEntry(returnFloatString)) {
                returnFloat = Float.parseFloat(returnFloatString);
                if (returnFloat >= min && returnFloat <= max) {
                    break;
                } else {
                    System.out.format("%.2f is not a number between %.2f and %.2f. Try again.%n", returnFloat, min, max);
                }
            }
        }
        return returnFloat;
    }

    @Override
    public int readInt(String prompt) {
        System.out.println(prompt);
        String returnIntString;
        int returnInt;
        while (true) {
            returnIntString = scanner.next();
            if (validEntry(returnIntString)) {
                returnInt = Integer.parseInt(returnIntString);
                break;
            }
        }
        return returnInt;
    }

    @Override
    public int readInt(String prompt, long min, long max) {
        System.out.println(prompt);
        String returnIntString;
        int returnInt;
        while (true) {
            returnIntString = scanner.next();
            if (validEntry(returnIntString)) {
                returnInt = Integer.parseInt(returnIntString);
                if (returnInt >= min && returnInt <= max) {
                    break;
                } else {
                    System.out.format("%d is not a number between %d and %d. Try again.%n", returnInt, min, max);
                }
            }
        }
        return returnInt;
    }

    @Override
    public long readLong(String prompt) {
        System.out.println(prompt);
        String returnLongString;
        long returnLong;
        while (true) {
            returnLongString = scanner.next();
            if (validEntry(returnLongString)) {
                returnLong = Integer.parseInt(returnLongString);
                break;
            }
        }
        return returnLong;
    }

    @Override
    public long readLong(String prompt, long min, long max) {
        System.out.println(prompt);
        String returnLongString;
        long returnLong;
        while (true) {
            returnLongString = scanner.next();
            if (validEntry(returnLongString)) {
                returnLong = Long.parseLong(returnLongString);
                if (returnLong >= min && returnLong <= max) {
                    break;
                } else {
                    System.out.format("%d is not a number between %d and %d. Try again.%n", returnLong, min, max);
                }
            }
        }
        return returnLong;
    }
    
    
    //Ask Corbin about this.
    @Override
    public String readString(String prompt) {
        String returnString;
        System.out.println(prompt);
        while (true) {
            returnString = scanner.nextLine();
            if (returnString.length() > 0) {
                break;
            }
        }
        return returnString;
    }

    public static boolean validEntry(String num) {
        try {
            int i = Integer.parseInt(num);
            return true;
        } catch (NumberFormatException nfe) {
            System.out.println("That is not a valid entry. Try again.");
            return false;
        }
    }
    
}
