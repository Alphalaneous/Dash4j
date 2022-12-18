package com.alphalaneous;

public enum PulseMode {

    Color (0),
    HSV (1);

    private int value;
    PulseMode(int value){
        this.value = value;
    }

    public int toInt(){
        return value;
    }

    public String toString(){
        return String.valueOf(value);
    }
}
