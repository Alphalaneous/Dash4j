package com.alphalaneous;

public enum Speed {

    HALF(0),
    NORMAL(1),
    DOUBLE(2),
    TRIPLE(3),
    FOURTIMES(4);

    private int value;
    private Speed(int value){
        this.value = value;
    }

    public int toInt(){
        return value;
    }


}
