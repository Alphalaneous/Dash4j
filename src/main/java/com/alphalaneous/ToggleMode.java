package com.alphalaneous;

public enum ToggleMode {

    NONE(0),
    On (1),
    Off (2);

    private int value;
    ToggleMode(int value){
        this.value = value;
    }

    public int toInt(){
        return value;
    }

    public String toString(){
        return String.valueOf(value);
    }

}
