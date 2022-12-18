package com.alphalaneous;

public enum Gamemode {
    CUBE(0),
    SHIP(1),
    UFO(2),
    BALL(3),
    WAVE(4),
    ROBOT(5),
    SPIDER(6),
    UNKNOWN(-1);

    private int value;

    private Gamemode(int value){
        this.value = value;
    }

    public int toInt(){
        return value;
    }

}
