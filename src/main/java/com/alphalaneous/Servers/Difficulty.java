package com.alphalaneous.Servers;

public enum Difficulty {

    DEMONS (-2),
    NA (-1),
    EASY (1),
    NORMAL (2),
    HARD (3),
    HARDER (4),
    INSANE (5);

    private int value = 0;

    private Difficulty(int value){
        this.value = value;
    }

    public int toInt(){
        return value;
    }

    public String toString(){
        return String.valueOf(value);
    }

}
