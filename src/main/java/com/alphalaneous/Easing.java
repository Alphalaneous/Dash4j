package com.alphalaneous;

public enum Easing {

    None (0),
    EaseInOut (1),
    EaseIn (2),
    EaseOut (3),
    ElasticInOut (4),
    ElasticIn (5),
    ElasticOut (6),
    BounceInOut (7),
    BounceIn (8),
    BounceOut (9),
    ExponentialInOut(10),
    ExponentialIn(11),
    ExponentialOut(12),
    SineInOut(13),
    SineIn(14),
    SineOut(15),
    BackInOut(16),
    BackIn(17),
    BackOut(18);

    private int value;
    Easing(int value){
        this.value = value;
    }

    public int toInt(){
        return value;
    }

    public String toString(){
        return String.valueOf(value);
    }

}
