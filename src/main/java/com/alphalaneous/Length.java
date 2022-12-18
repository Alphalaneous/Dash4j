package com.alphalaneous;

public enum Length {

    TINY (0),
    SHORT (1),
    MEDIUM (2),
    LONG (3),
    XL (4);

    private int value = 0;
    Length(int value){
        this.value = value;
    }

    public int toInt(){
        return value;
    }

    public static Length fromInteger(int value){
        switch (value){
            case 0: return TINY;
            case 1: return SHORT;
            case 2: return MEDIUM;
            case 3: return LONG;
            case 4: return XL;
        }
        return TINY;
    }

    public String toString(){
        return String.valueOf(value);
    }

}
