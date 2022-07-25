package com.alphalaneous;

public class ObjectData {

    public float x;
    public float y;
    public int z;
    public float scale;
    public float rotation;
    public int editorLayer1;
    public int editorLayer2;
    public int ID;

    public ObjectData(int ID, float x, float y, int z, float scale, float rotation, int editorLayer1, int editorLayer2){
        this.ID = ID;
        this.x = x;
        this.y = y;
        this.z = z;
        this.scale = scale;
        this.rotation = rotation;
        this.editorLayer1 = editorLayer1;
        this.editorLayer2 = editorLayer2;
    }

    public int getID(){
        return ID;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public int getZ() {
        return z;
    }

    public float getScale() {
        return scale;
    }

    public float getRotation() {
        return rotation;
    }

    public int getEditorLayer1() {
        return editorLayer1;
    }

    public int getEditorLayer2() {
        return editorLayer2;
    }

}
