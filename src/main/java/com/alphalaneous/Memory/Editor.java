package com.alphalaneous.Memory;

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

        int ID = MemoryHelper.read(IDOffsets, 4).getInt(0);
        float x = MemoryHelper.read(xOffsets, 4).getFloat(0);
        float y = MemoryHelper.read(yOffsets, 4).getFloat(0);
        int z = MemoryHelper.read(zOffsets, 4).getInt(0);
        float scale = MemoryHelper.read(scaleOffsets, 4).getFloat(0);
        float rotation = MemoryHelper.read(rotationOffsets, 4).getFloat(0);
        int editorLayer1 = MemoryHelper.read(editorLayer1Offsets, 4).getInt(0);
        int editorLayer2 = MemoryHelper.read(editorLayer2Offsets, 4).getInt(0);

        return new ObjectData(ID, x, y, z, scale, rotation, editorLayer1, editorLayer2);
    }

    public static void setObjectID(int ID){
        if(Global.isInEditor()) {
            int[] offsets = {0x168, 0x380, 0x27C};
            MemoryHelper.writeInt(offsets, ID);
        }
    }
    public static void setObjectX(float x){
        if(Global.isInEditor()) {
            int[] offsets = {0x168, 0x380, 0x2C4, 0x34};
            MemoryHelper.writeFloat(offsets, x);
        }
    }
    public static void setObjectY(float y){
        if(Global.isInEditor()) {
            int[] offsets = {0x168, 0x380, 0x2C4, 0x38};
            MemoryHelper.writeFloat(offsets, y);
        }
    }
    public static void setObjectZ(int z){
        if(Global.isInEditor()) {
            int[] offsets = {0x168, 0x380, 0x2C4, 0x3BC};
            MemoryHelper.writeInt(offsets, z);
        }
    }
    public static void setObjectScale(float scale){
        if(Global.isInEditor()) {
            int[] offsets = {0x168, 0x380, 0x2C4, 0x35C};
            MemoryHelper.writeFloat(offsets, scale);
        }
    }
    public static void setObjectRotation(float rotation){
        if(Global.isInEditor()) {
            int[] offsets = {0x168, 0x380, 0x2C4, 0x20};
            MemoryHelper.writeFloat(offsets, rotation);
        }
    }
    public static void setObjectEditorLayer1(int value){
        if(Global.isInEditor()) {
            int[] offsets = {0x168, 0x380, 0x2C4, 0x40C};
            MemoryHelper.writeInt(offsets, value);
        }
    }
    public static void setObjectEditorLayer2(int value){
        if(Global.isInEditor()) {
            int[] offsets = {0x168, 0x380, 0x2C4, 0x410};
            MemoryHelper.writeInt(offsets, value);
        }
    }

    public static float getLength(){

        int[] lengthOffsets = {0x2E67A4};

        return MemoryHelper.read(lengthOffsets, 4).getFloat(0);
    }

    public static int getLayer(){
        int[] layerOffsets = {0x168, 0x354};

        return MemoryHelper.read(layerOffsets, 4).getInt(0);
    }

    public static float getGridSize(){

        int[] gridSizeOffsets = {0x1DCA49};

        return MemoryHelper.read(gridSizeOffsets, 4).getFloat(0);
    }

}
