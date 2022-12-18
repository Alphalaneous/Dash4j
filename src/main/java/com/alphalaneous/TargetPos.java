package com.alphalaneous;

public enum TargetPos {

    NONE (0),
    XOnly (1),
    YOnly (2);

    private int value;
    TargetPos(int value){
        this.value = value;
    }

    public int toInt(){
        return value;
    }

    public String toString(){
        return String.valueOf(value);
    }

}
