package com.alphalaneous;

public class GuidelineProperties {

    float timestamp;
    GuidelineColor colorValue;

    public GuidelineProperties(float timestamp, GuidelineColor colorValue){
        this.timestamp = timestamp;
        this.colorValue = colorValue;
    }

    public String toString(){
        return timestamp + "~" + colorValue.toFloat();
    }
}
