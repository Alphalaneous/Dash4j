package com.alphalaneous;

public enum PulseTargetType {

    Channel (0),
    Group (1);

    private int value;
    PulseTargetType(int value){
        this.value = value;
    }

    public int toInt(){
        return value;
    }

    public String toString(){
        return String.valueOf(value);
    }

}
