package com.alphalaneous;

public enum PlayerColor {

    NONE(-1),
    Player1 (0),
    Player2 (1);

    private int value;
    PlayerColor(int value){
        this.value = value;
    }

    public int toInt(){
        return value;
    }

    public String toString(){
        return String.valueOf(value);
    }
}
