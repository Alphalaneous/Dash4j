package com.alphalaneous.GD;

import com.alphalaneous.Interfaces.Function;
import com.alphalaneous.Memory;
import com.alphalaneous.Gamemode;
import com.alphalaneous.LevelPosition;
import com.alphalaneous.Utilities;

public class Level {

    public static LevelPosition getPosition(){

        if(!Global.isInLevel()) return null;

        int[] xOffsets = {0x164, 0x224, 0x67C};
        int[] yOffsets = {0x164, 0x224, 0x680};

        return new LevelPosition(Memory.read(xOffsets, 4).getFloat(0),
                Memory.read(yOffsets, 4).getFloat(0));
    }
    public static void setX(float x){
        if(Global.isInLevel()) {
            int[] offsets = {0x164, 0x224, 0x67C};
            Memory.writeFloat(offsets, x);
        }
    }
    public static void setY(float y){
        if(Global.isInLevel()) {
            int[] offsets = {0x164, 0x224, 0x680};
            Memory.writeFloat(offsets, y);
        }
    }

    public static Thread onX(float x, Function function){
        Thread a = new Thread(() ->{

            float lastVal = 0;

            while(true) {
                if(getPosition() != null) {
                    float val = getPosition().getX();
                    if(Utilities.isBetween(x, lastVal, val, 2f)) function.run();

                    lastVal = val;
                    Utilities.sleep(1);
                }
            }
        });
        a.start();
        return a;
    }

    public static Thread onY(float y, Function function){
        Thread a = new Thread(() ->{

            float lastVal = 0;

            while(true) {
                if(getPosition() != null) {
                    float val = getPosition().getY();

                    if(Utilities.isBetween(y, lastVal, val, 2f)) function.run();

                    lastVal = val;
                    Utilities.sleep(1);
                }
            }
        });
        a.start();
        return a;
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

    public static void setGamemode(Gamemode gamemode){
        if(Global.isInLevel()) {

            int[] offsets = {0x164, 0x224, 0x638};

            byte[] gamemodes = {0, 0, 0, 0, 0, 0};

            if (gamemode != Gamemode.CUBE) {
                switch (gamemode) {
                    case SHIP:
                        gamemodes[0] = 1;
                        break;
                    case UFO:
                        gamemodes[1] = 1;
                        break;
                    case BALL:
                        gamemodes[2] = 1;
                        break;
                    case WAVE:
                        gamemodes[3] = 1;
                        break;
                    case ROBOT:
                        gamemodes[4] = 1;
                        break;
                    case SPIDER:
                        gamemodes[5] = 1;
                        break;
                }
            }
            Memory.writeBytes(offsets, gamemodes);
        }
    }


    public static Thread onGamemode(Gamemode gamemode, Function function){
        Thread a = new Thread(() ->{

            boolean isGamemode = false;

            while(true) {

                Gamemode gamemode1 = getGamemode();

                if (gamemode1 == gamemode && !isGamemode) {
                    function.run();
                    isGamemode = true;
                }
                if(gamemode1 != gamemode){
                    isGamemode = false;
                }

                Utilities.sleep(1);
            }
        });
        a.start();
        return a;
    }

    public static float getPercent(){

        if(!Global.isInLevel()) return -1;

        LevelPosition position = getPosition();
        if(position == null) return -1;

        float percent = position.getX() / getLength() * 100;

        if(percent < 100) return percent;
        else return 100;
    }

    public static Thread onPercent(float percent, Function function){
        Thread a = new Thread(() ->{

            float lastVal = 0;

            while(true) {
                float val = getPercent();

                if(Utilities.isBetween(percent, lastVal, val, 0.2f)) function.run();

                lastVal = val;
                Utilities.sleep(1);
            }
        });
        a.start();
        return a;
    }

    public static int getID(){

        if(!Global.isInLevel()) return -1;


        int[] levelID = {0x164, 0x22C, 0x114, 0xF8};
        return Memory.read(levelID, 4).getInt(0);
    }

    public static Thread onID(int ID, Function function){
        Thread a = new Thread(() ->{

            boolean hasLevel = false;

            while(true) {
                int curID = getID();

                if (curID == ID && !hasLevel) {
                    function.run();
                    hasLevel = true;
                }
                if(curID != ID){
                    hasLevel = false;
                }
                Utilities.sleep(1);
            }
        });
        a.start();
        return a;
    }

    public static float getSpeed(){

        if(!Global.isInLevel()) return -1;

        int[] speed = {0x164, 0x224, 0x648};
        return Memory.read(speed, 4).getFloat(0);
    }

    public static void setSpeed(float speed){
        if(Global.isInLevel()) {
            int[] offsets = {0x164, 0x224, 0x648};
            Memory.writeFloat(offsets, speed);
        }
    }

    public static Thread onSpeed(float speed, Function function){
        Thread a = new Thread(() ->{

            float lastVal = 0;
            boolean hasSpeed = false;

            while(true) {
                float val = getSpeed();

                boolean isBetween = Utilities.isBetween(speed, lastVal, val, 0.2f);

                if(isBetween && !hasSpeed) {
                    function.run();
                    hasSpeed = true;
                }
                if(!isBetween) hasSpeed = false;
                lastVal = val;
                Utilities.sleep(1);
            }
        });
        a.start();
        return a;
    }

    public static float getSize(){

        if(!Global.isInLevel()) return -1;

        int[] size = {0x164, 0x224, 0x644};
        return Memory.read(size, 4).getFloat(0);
    }

    public static void setSize(float size){

        if(Global.isInLevel()) {
            int[] offsets = {0x164, 0x224, 0x644};
            Memory.writeFloat(offsets, size);
        }
    }

    public static Thread onSize(float size, Function function){
        Thread a  = new Thread(() ->{

            float lastVal = 0;
            boolean hasSize = false;

            while(true) {
                float val = getSize();

                boolean isBetween = Utilities.isBetween(size, lastVal, val, 0.2f);

                if(isBetween && !hasSize){
                    function.run();
                    hasSize = true;
                }
                if(!isBetween) hasSize = false;

                lastVal = val;
                Utilities.sleep(1);
            }
        });
        a.start();
        return a;
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

    public static void setAttempt(int attempt){
        if(Global.isInLevel()) {
            int[] offsets = {0x164, 0x4A8};
            Memory.writeInt(offsets, attempt);
        }
    }

    public static Thread onAttempt(int attempt, Function function){
        Thread a = new Thread(() ->{

            boolean didAttempt = false;

            while(true) {

                int attempts = getAttempt();

                if (attempts == attempt && !didAttempt) {
                    function.run();
                    didAttempt = true;
                }
                if(attempts != attempt){
                    didAttempt = false;
                }
                Utilities.sleep(1);
            }
        });
        a.start();
        return a;
    }

    public static int getJumps(){

        if(!Global.isInLevel()) return -1;

        int[] jumps = {0x164, 0x22C, 0x114, 0x224};
        return Memory.read(jumps, 4).getInt(0);
    }

    public static void setJumps(int jumps){
        if(Global.isInLevel()) {
            int[] offsets = {0x164, 0x22C, 0x114, 0x224};
            Memory.writeInt(offsets, jumps);
        }
    }

    public static int getNormalPercentage(){

        if(!Global.isInLevel()) return -1;

        int[] percentage = {0x164, 0x22C, 0x114, 0x248};
        return Memory.read(percentage, 4).getInt(0);
    }

    public static void setNormalPercentage(int percentage){
        if(Global.isInLevel()) {
            int[] offsets = {0x164, 0x22C, 0x114, 0x248};
            Memory.writeInt(offsets, percentage);
        }
    }

    public static int getPracticePercentage(){

        if(!Global.isInLevel()) return -1;

        int[] percentage = {0x164, 0x22C, 0x114, 0x26C};
        return Memory.read(percentage, 4).getInt(0);
    }

    public static void setPracticePercentage(int percentage){
        if(Global.isInLevel()) {
            int[] offsets = {0x164, 0x22C, 0x114, 0x26C};
            Memory.writeInt(offsets, percentage);
        }
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

    public static Thread onDeath(Function function){
        Thread a = new Thread(() ->{
            boolean died = false;

            while(true) {
                boolean isDead = isDead();
                if (isDead && !died && Global.isInLevel()) {
                    function.run();
                    died = true;
                }
                if(!isDead) died = false;
                Utilities.sleep(1);
            }
        });
        a.start();
        return a;
    }
}
