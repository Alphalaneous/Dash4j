package com.alphalaneous;

public enum Comparison {

    Equals (0),
    Larger (1),
    Smaller (2);

    private int value;
    Comparison(int value){
        this.value = value;
    }

    public int toInt(){
        return value;
    }

    public String toString(){
        return String.valueOf(value);
    }

}
