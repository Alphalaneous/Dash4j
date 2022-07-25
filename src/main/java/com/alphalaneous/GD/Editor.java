package com.alphalaneous.GD;

import com.alphalaneous.Memory;
import com.alphalaneous.ObjectData;

public class Editor {

    public static ObjectData getObject(){
        if(!Global.isInEditor()) return null;
        int[] IDOffsets = {0x168, 0x380, 0x27C};
        int[] xOffsets = {0x168, 0x380, 0x2C4, 0x34};
        int[] yOffsets = {0x168, 0x380, 0x2C4, 0x38};
        int[] zOffsets = {0x168, 0x380, 0x2C4, 0x3BC};
        int[] scaleOffsets = {0x168, 0x380, 0x2C4, 0x35C};
        int[] rotationOffsets = {0x168, 0x380, 0x2C4, 0x20};
        int[] editorLayer1Offsets = {0x168, 0x380, 0x2C4, 0x40C};
        int[] editorLayer2Offsets = {0x168, 0x380, 0x2C4, 0x410};

        int ID = Memory.read(IDOffsets, 4).getInt(0);
        float x = Memory.read(xOffsets, 4).getFloat(0);
        float y = Memory.read(yOffsets, 4).getFloat(0);
        int z = Memory.read(zOffsets, 4).getInt(0);
        float scale = Memory.read(scaleOffsets, 4).getFloat(0);
        float rotation = Memory.read(rotationOffsets, 4).getFloat(0);
        int editorLayer1 = Memory.read(editorLayer1Offsets, 4).getInt(0);
        int editorLayer2 = Memory.read(editorLayer2Offsets, 4).getInt(0);

        return new ObjectData(ID, x, y, z, scale, rotation, editorLayer1, editorLayer2);
    }

    public static void setObjectID(int ID){
        if(Global.isInEditor()) {
            int[] offsets = {0x168, 0x380, 0x27C};
            Memory.writeInt(offsets, ID);
        }
    }
    public static void setObjectX(float x){
        if(Global.isInEditor()) {
            int[] offsets = {0x168, 0x380, 0x2C4, 0x34};
            Memory.writeFloat(offsets, x);
        }
    }
    public static void setObjectY(float y){
        if(Global.isInEditor()) {
            int[] offsets = {0x168, 0x380, 0x2C4, 0x38};
            Memory.writeFloat(offsets, y);
        }
    }
    public static void setObjectZ(int z){
        if(Global.isInEditor()) {
            int[] offsets = {0x168, 0x380, 0x2C4, 0x3BC};
            Memory.writeInt(offsets, z);
        }
    }
    public static void setObjectScale(float scale){
        if(Global.isInEditor()) {
            int[] offsets = {0x168, 0x380, 0x2C4, 0x35C};
            Memory.writeFloat(offsets, scale);
        }
    }
    public static void setObjectRotation(float rotation){
        if(Global.isInEditor()) {
            int[] offsets = {0x168, 0x380, 0x2C4, 0x20};
            Memory.writeFloat(offsets, rotation);
        }
    }
    public static void setObjectEditorLayer1(int value){
        if(Global.isInEditor()) {
            int[] offsets = {0x168, 0x380, 0x2C4, 0x40C};
            Memory.writeInt(offsets, value);
        }
    }
    public static void setObjectEditorLayer2(int value){
        if(Global.isInEditor()) {
            int[] offsets = {0x168, 0x380, 0x2C4, 0x410};
            Memory.writeInt(offsets, value);
        }
    }

    public static float getLength(){

        int[] lengthOffsets = {0x2E67A4};

        return Memory.read(lengthOffsets, 4).getFloat(0);
    }

    public static int getLayer(){
        int[] layerOffsets = {0x168, 0x354};

        return Memory.read(layerOffsets, 4).getInt(0);
    }

    public static float getGridSize(){

        int[] gridSizeOffsets = {0x1DCA49};

        return Memory.read(gridSizeOffsets, 4).getFloat(0);
    }

}
