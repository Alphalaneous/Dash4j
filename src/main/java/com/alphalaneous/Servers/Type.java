package com.alphalaneous.Servers;

public enum Type {

    MOST_LIKED (0),
    MOST_DOWNLOADED (1),
    DEFAULT_SEARCH (2),
    TRENDING (3),
    RECENT (4),
    USER_LEVELS (5),
    FEATURED (6),
    MAGIC (7),
    SENT_LEVELS (8),
    LIST (10),
    AWARDED (11),
    FOLLOWED (12),
    FRIENDS (13),
    GDW_MOST_LIKED (15),
    HALL_OF_FAME (16),
    FEATURED_2 (17),
    UNKNOWN (18);

    private int value = 0;

    private Type(int value){
        this.value = value;
    }


    public int toInt(){
        return value;
    }

    public String toString(){
        return String.valueOf(value);
    }

}
