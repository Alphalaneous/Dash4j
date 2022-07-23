package com.alphalaneous.GD;

import com.alphalaneous.Memory;
import com.alphalaneous.Gamemode;
import com.alphalaneous.LevelPosition;

public class Level {

    public static LevelPosition getPosition(){

        if(!Global.isInLevel()) return null;

        int[] xOffsets = {0x164, 0x224, 0x67C};
        int[] yOffsets = {0x164, 0x224, 0x680};

        return new LevelPosition(Memory.read(xOffsets, 4).getFloat(0),
                Memory.read(yOffsets, 4).getFloat(0));
    }

    public static Gamemode getGamemode(){

        if(!Global.isInLevel()) return null;

        int[] gamemode = {0x164, 0x224, 0x638};

        byte[] gamemodes = Memory.read(gamemode, 24).getByteArray(0,6);

        boolean isCube = true;

        for(byte b : gamemodes){
            if(b >= 1) {
                isCube = false;
                break;
            }
        }
        if(isCube) return Gamemode.CUBE;
        if(gamemodes[0] >= 1) return Gamemode.SHIP;
        if(gamemodes[1] >= 1) return Gamemode.UFO;
        if(gamemodes[2] >= 1) return Gamemode.BALL;
        if(gamemodes[3] >= 1) return Gamemode.WAVE;
        if(gamemodes[4] >= 1) return Gamemode.ROBOT;
        if(gamemodes[5] >= 1) return Gamemode.SPIDER;

        return Gamemode.UNKNOWN;
    }

    public static float getPercent(){

        if(!Global.isInLevel()) return -1;

        LevelPosition position = getPosition();
        if(position == null) return -1;

        float percent = position.getX() / getLength() * 100;

        if(percent < 100) return percent;
        else return 100;
    }

    public static int getID(){

        if(!Global.isInLevel()) return -1;


        int[] levelID = {0x164, 0x22C, 0x114, 0xF8};
        return Memory.read(levelID, 4).getInt(0);
    }

    public static float getSpeed(){

        if(!Global.isInLevel()) return -1;

        int[] speed = {0x164, 0x224, 0x648};
        return Memory.read(speed, 4).getFloat(0);
    }

    public static float getSize(){

        if(!Global.isInLevel()) return -1;

        int[] size = {0x164, 0x224, 0x644};
        return Memory.read(size, 4).getFloat(0);
    }

    public static int getTotalAttempts(){

        if(!Global.isInLevel()) return -1;

        int[] attempts = {0x164, 0x22C, 0x114, 0x218};
        return Memory.read(attempts, 4).getInt(0);
    }

    public static int getAttempt(){

        if(!Global.isInLevel()) return -1;

        int[] attempt = {0x164, 0x4A8};
        return Memory.read(attempt, 4).getInt(0);
    }

    public static int getJumps(){

        if(!Global.isInLevel()) return -1;

        int[] jumps = {0x164, 0x22C, 0x114, 0x224};
        return Memory.read(jumps, 4).getInt(0);
    }

    public static int getNormalPercentage(){

        if(!Global.isInLevel()) return -1;

        int[] percentage = {0x164, 0x22C, 0x114, 0x248};
        return Memory.read(percentage, 4).getInt(0);
    }

    public static int getPracticePercentage(){

        if(!Global.isInLevel()) return -1;

        int[] percentage = {0x164, 0x22C, 0x114, 0x26C};
        return Memory.read(percentage, 4).getInt(0);
    }

    public static int getSongID(){

        if(!Global.isInLevel()) return -1;

        int[] songID = {0x164, 0x488, 0x1C4};
        return Memory.read(songID, 4).getInt(0);
    }

    public static int getStars(){

        if(!Global.isInLevel()) return -1;

        int[] stars = {0x164, 0x22C, 0x114, 0x2AC};
        return Memory.read(stars, 4).getInt(0);
    }

    public static int getFeaturedScore(){

        if(!Global.isInLevel()) return -1;

        int[] score = {0x164, 0x22C, 0x114, 0x27C};
        return Memory.read(score, 4).getInt(0);
    }

    public static boolean isFeatured(){
        return getFeaturedScore() > 0;
    }

    public static boolean isEpic(){

        if(!Global.isInLevel()) return false;

        int[] isEpic = {0x164, 0x22C, 0x114, 0x280};
        return Memory.read(isEpic, 1).getByte(0) > 0;
    }

    public static boolean isDemon(){

        if(!Global.isInLevel()) return false;

        int[] isDemon = {0x164, 0x22C, 0x114, 0x29C};
        return Memory.read(isDemon, 1).getByte(0) > 0;
    }

    public static boolean isAuto(){

        if(!Global.isInLevel()) return false;

        int[] isAuto = {0x164, 0x22C, 0x114, 0x2B0};
        return Memory.read(isAuto, 1).getByte(0) > 0;
    }

    public static int getDifficultyValue(){

        if(!Global.isInLevel()) return -1;

        int[] value = {0x164, 0x22C, 0x114, 0x1E4};
        return Memory.read(value, 4).getInt(0);
    }

    public static int getDemonDifficultyValue(){

        if(!Global.isInLevel()) return -1;

        int[] value = {0x164, 0x22C, 0x114, 0x2A0};
        return Memory.read(value, 4).getInt(0);
    }

    public static String getLevelName(){

        if(!Global.isInLevel()) return null;

        int[] levelName = {0x164, 0x22C, 0x114, 0xFC};
        return Memory.readString(levelName, 32);
    }

    public static String getLevelCreator(){

        if(!Global.isInLevel()) return null;

        int[] creator = {0x164, 0x22C, 0x114, 0x144};
        return Memory.readString(creator, 32);
    }

    public static String getEditorLevelName(){

        if(!Global.isInLevel()) return null;

        int[] levelName = {0x168, 0x124, 0xEC, 0x110, 0x114, 0xFC};
        return Memory.readString(levelName, 32);
    }

    public static float getLength(){

        if(!Global.isInLevel()) return -1;

        int[] length = {0x164, 0x3B4};
        return Memory.read(length, 4).getFloat(0);
    }

    public static int getObjectCount(){

        if(!Global.isInLevel()) return -1;

        int[] objectCount = {0x168, 0x3A0};
        return Memory.read(objectCount, 4).getInt(0);
    }

    public static String getCreatorName(){

        if(!Global.isInLevel()) return null;

        int[] creatorName = {0x164, 0x22C, 0x114, 0xFC};
        return Memory.readString(creatorName, 32);
    }
    public static boolean isDead(){

        if(!Global.isInLevel()) return true;

        int[] isAlive = {0x164, 0x39C};
        return Memory.read(isAlive, 1).getByte(0) > 0;
    }
}
