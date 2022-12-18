package com.alphalaneous.Memory;

public class LevelPosition {

    private final float x, y;

    public LevelPosition(float x, float y){
        this.x = x;
        this.y = y;
    }

    public float getX(){
        return x;
    }
    public float getY(){
        return y;
    }
    @Override
    public String toString(){
        return this.getClass().getName() + "[x=" + x + ",y=" + y + "]";
    }
}
