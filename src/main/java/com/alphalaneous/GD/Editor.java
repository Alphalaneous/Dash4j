package com.alphalaneous.GD;

import com.alphalaneous.Memory;
import com.alphalaneous.ObjectData;

public class Editor {

    public static ObjectData getObject(){

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
        float z = Memory.read(zOffsets, 4).getFloat(0);
        float scale = Memory.read(scaleOffsets, 4).getFloat(0);
        float rotation = Memory.read(rotationOffsets, 4).getFloat(0);
        int editorLayer1 = Memory.read(editorLayer1Offsets, 4).getInt(0);
        int editorLayer2 = Memory.read(editorLayer2Offsets, 4).getInt(0);

        return new ObjectData(ID, x, y, z, scale, rotation, editorLayer1, editorLayer2);
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
