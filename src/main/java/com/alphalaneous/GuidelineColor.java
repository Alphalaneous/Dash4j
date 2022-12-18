package com.alphalaneous;

public enum GuidelineColor {

    TRANSLUCENT(0.7f),
    ORANGE(0.8f),
    YELLOW(0.9f),
    GREEN(1f);

    private final float value;

    private GuidelineColor(float value){
        this.value = value;
    }

    public float toFloat(){
        return value;
    }

}
