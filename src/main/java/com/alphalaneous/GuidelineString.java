package com.alphalaneous;

import java.util.ArrayList;

public class GuidelineString {

    private final ArrayList<GuidelineProperties> guidelineProperties = new ArrayList<>();

    public void addGuidelineProperties(GuidelineProperties properties){
        guidelineProperties.add(properties);
    }

    public String toString(){

        StringBuilder builder = new StringBuilder();

        for(GuidelineProperties properties : guidelineProperties){
            builder.append(properties.toString()).append("~");
        }

        return builder.toString();

    }


}
