package com.crimson.friendlycolors.model;

import android.graphics.Color;

import java.util.Random;

/**
 * Created by mfraser on 6/29/2015.
 */
public class FriendlyData {

    private String[] friendlyTexts;
    private Scheme[] mSchemes;
    private Random mRandom = new Random();

    public FriendlyData() {
        friendlyTexts = new String[5];

        friendlyTexts[0] = "%1$s, in a world of ladybugs, you are a tiger. Yeah, you're that much better than everyone else.";
        friendlyTexts[1] = "%1$s, you have an incredible knack for turning any conversation into an awkward one.";
        friendlyTexts[2] = "%1$s, you're like sunshine on a rainy day.";
        friendlyTexts[3] = "%1$s, you're ability to fall asleep, regardless of location and amount of comfort, is something to be admired.";
        friendlyTexts[4] = "%1$s, if someone invented a time machine that could only be used by cool people, you'd be able to travel back in time, no problem.";

        //"black", "red", "blue", "green", "white", "yellow"
        mSchemes = new Scheme[6];
        mSchemes[0] = new Scheme("black");
        mSchemes[1] = new Scheme("red");
        mSchemes[2] = new Scheme("blue");
        mSchemes[3] = new Scheme("green");
        mSchemes[4] = new Scheme("white");
        mSchemes[5] = new Scheme("yellow");
    }

    public String getRandomText() {
        int i = mRandom.nextInt(5);
        return friendlyTexts[i];
    }

    public Scheme getColorScheme(String color) {
        String[] sColors = {"black", "red", "blue", "green", "white", "yellow"};
        int index = 0;
        for (int i = 0; i < sColors.length; i++) {
            if (sColors[i].equalsIgnoreCase(color)) {
                index = i;
            }
        }
        return mSchemes[index];
    }

}
