package com.alphalaneous;

import java.util.ArrayList;

public class ColorString {

    private final ArrayList<ColorProperties> colorProperties = new ArrayList<>();

    public void addColorProperty(ColorProperties properties){
        colorProperties.add(properties);
    }


    public String toString(){

        StringBuilder builder = new StringBuilder();

        for(ColorProperties properties : colorProperties){
            builder.append(properties).append("|");
        }

        return builder.toString();

    }
}
