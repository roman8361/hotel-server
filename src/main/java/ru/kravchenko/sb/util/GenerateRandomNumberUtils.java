package ru.kravchenko.sb.util;

public class GenerateRandomNumberUtils {

    /**
     * returns random integer between minimum and maximum range
     * Random value between 1000 and 9999
     */
    public static int getRandomInteger(int maximum, int minimum){
        return ((int) (Math.random()*(maximum - minimum))) + minimum;
    }

}
