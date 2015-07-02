package com.crimson.friendlycolors.model;

import android.graphics.Color;

/**
 * Created by mfraser on 6/29/2015.
 */
public class Scheme {

    private int textColor;
    private int bgColorNum;

    public Scheme(String bgColor) {

        String[] sColors = {"black", "red", "blue", "green", "white", "yellow"};
        int[] textColors = {Color.WHITE, Color.BLACK, Color.WHITE, Color.BLACK, Color.BLACK, Color.BLACK};
        int[] bgColors = {Color.BLACK, Color.RED, Color.BLUE, Color.GREEN, Color.WHITE, Color.YELLOW};

        for (int i = 0; i < sColors.length; i++) {
            if (sColors[i].equalsIgnoreCase(bgColor)) {
                textColor = textColors[i];
                bgColorNum = bgColors[i];
            }
        }
    }

    public int getTextColor() {
        return textColor;
    }

    public void setTextColor(int textColor) {
        this.textColor = textColor;
    }

    public int getBgColorNum() {
        return bgColorNum;
    }

    public void setBgColorNum(int bgColorNum) {
        this.bgColorNum = bgColorNum;
    }
}
