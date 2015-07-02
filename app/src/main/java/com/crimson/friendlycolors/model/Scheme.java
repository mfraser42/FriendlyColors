package com.crimson.friendlycolors.model;

public class Scheme {

    private String textHexColor;
    private String bgHexColor;

    public String getTextHexColor() {
        return textHexColor;
    }

    public String getBgHexColor() {
        return bgHexColor;
    }

    public Scheme(String bgColor) {

        String[] sColors = {"black", "red", "blue", "green", "white", "yellow", "mint", "pink"};
        String[] textColors = {"#FFFFFF", "#0a000a","#FFFFFF", "#0a000a", "#0a000a", "#0a000a", "#0a000a", "#0a000a"};
        String[] bgColors = {"#0a000a", "#fb250d", "#575bee", "#16c72b","#FFFFFF", "#fbf55e", "#71ceac", "#ffc0cb"};

        for (int i = 0; i < sColors.length; i++) {
            if (sColors[i].equalsIgnoreCase(bgColor)) {
                textHexColor = textColors[i];
                bgHexColor = bgColors[i];
            }
        }
    }
}
