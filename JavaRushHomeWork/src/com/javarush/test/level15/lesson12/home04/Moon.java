package com.javarush.test.level15.lesson12.home04;

/**
 * Created by ESavitsky on 10/30/2016.
 */
public class Moon implements Planet
{
    private static Moon instance;
    private Moon(){}

    public static Moon getInstance()
    {
        if(instance == null)
        {
            instance = new Moon();
        }
        return instance;
    }
}
