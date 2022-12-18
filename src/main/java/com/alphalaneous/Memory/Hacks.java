package com.alphalaneous.Memory;

import static com.alphalaneous.Memory.MemoryHelper.writeToAddress;

public class Hacks {

    public static void setNoclip(boolean enabled){
        if(enabled) writeToAddress(0x20A23C, new byte[]{(byte) 0xE9, 0x79, 0x06, 0x00, 0x00});
        else writeToAddress(0x20A23C, new byte[]{(byte) 0x6A, 0x14, (byte) 0x8B, (byte) 0xCB, (byte) 0xFF});

    }

    public static void setSafeMode(boolean enabled){
        if(enabled){
            writeToAddress(0x20A3D1, new byte[]{(byte) 0xE9, 0x7B, 0x01, 0x00, 0x00, (byte) 0x90});
            writeToAddress(0x1FF80B, new byte[]{(byte) 0x90, (byte) 0x90, (byte) 0x90, (byte) 0x90, (byte) 0x90, (byte) 0x90, (byte) 0x90});
        }
        else {
            writeToAddress(0x20A3D1, new byte[]{0x0F, (byte) 0x85, 0x7A, 0x01, 0x00, 0x00});
            writeToAddress(0x1FF80B, new byte[]{0x7D, 0x0C, (byte) 0xE9, (byte) 0xC2, (byte) 0xFB, (byte) 0xFF, (byte) 0xFF});
        }
    }


    public static void setPracticeMusicHack(boolean enabled){
        if(enabled) {
            writeToAddress(0x20C925, new byte[]{(byte) 0x90, (byte) 0x90, (byte) 0x90, (byte) 0x90, (byte) 0x90, (byte) 0x90});
            writeToAddress(0x20D143, new byte[]{(byte) 0x90, (byte) 0x90});
            writeToAddress(0x20A563, new byte[]{(byte) 0x90, (byte) 0x90});
            writeToAddress(0x20A595, new byte[]{(byte) 0x90, (byte) 0x90});
        }
        else {
            writeToAddress(0x20C925, new byte[]{0x0F, (byte) 0x85, (byte) 0xF7, 0x00, 0x00, 0x00});
            writeToAddress(0x20D143, new byte[]{0x75, 0x41});
            writeToAddress(0x20A563, new byte[]{0x75, 0x3E});
            writeToAddress(0x20A595, new byte[]{0x75, 0x0C});
        }
    }

    public static void setNoSpikes(boolean enabled){
        if(enabled){
            writeToAddress(0x205347, new byte[]{0x75});
        }
        else {
            writeToAddress(0x205347, new byte[]{0x74});
        }
    }

    public static void setNoHitbox(boolean enabled){

        if(enabled){
            writeToAddress(0x20456D, new byte[]{(byte) 0xB8, 0x07, 0x00, 0x00, 0x00, (byte) 0x90});
        }
        else {
            writeToAddress(0x20456D, new byte[]{(byte) 0x8B, (byte) 0x83, 0x00, 0x03, 0x00, 0x00});
        }
    }

    public static void setNoSolids(boolean enabled){

    }

}
