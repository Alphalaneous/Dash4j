package com.alphalaneous;

public enum PickupMode {

    Pickup (0),
    Toggle (1);

    private int value;
    PickupMode(int value){
        this.value = value;
    }

    public int toInt(){
        return value;
    }

    public String toString(){
        return String.valueOf(value);
    }

}
