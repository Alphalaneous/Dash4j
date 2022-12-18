package com.alphalaneous;

import java.util.LinkedList;

public class LevelString {

    LinkedList<LevelStartObject> levelStartObjects = new LinkedList<>();

    LinkedList<LevelObject> objects = new LinkedList<>();

    public LevelString(){
        levelStartObjects.add(new LevelStartObject());
    }

    public void addObject(LevelObject object){
        objects.add(object);
    }

    public void insertObjectAt(LevelObject object, int pos){
        objects.add(pos, object);
    }

    public void setLevelStartObject(LevelStartObject levelStartObject){

        levelStartObjects.add(levelStartObject);
    }

    public LevelStartObject getLevelStartObject(){
        return levelStartObjects.get(0);
    }

    public void addLevelStartObject(LevelStartObject object){
        levelStartObjects.add(object);
    }


    public String toString(){

        StringBuilder builder = new StringBuilder();

        for(LevelStartObject levelStartObject : levelStartObjects){
            builder.append(levelStartObject.toString()).append(";");
        }

        for(LevelObject object : objects){
            builder.append(object.toString()).append(";");
        }

        return builder.toString();
    }
}
