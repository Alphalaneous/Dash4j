package com.alphalaneous.GD;

import com.alphalaneous.Interfaces.Function;
import com.alphalaneous.Memory;
import com.alphalaneous.Utilities;

import java.awt.*;

public class Global {

    public static boolean isGDOpen(){
        return Memory.isGDOpen();
    }

    public static Thread onGDOpen(Function function){
        Thread a = new Thread(() ->{
            boolean lastIsGDOpen = false;
            while(true) {
                boolean isGDOpen = isGDOpen();
                if(isGDOpen && !lastIsGDOpen){
                    waitForLevel();
                    lastIsGDOpen = true;
                    function.run();
                }
                if(!isGDOpen) lastIsGDOpen = false;
                Utilities.sleep(1);
            }
        });
        a.start();
        return a;
    }

    public static boolean isInPractice(){
        int[] inPractice = {0x164, 0x495};
        return Memory.read(inPractice, 1).getByte(0) > 0;
    }

    public static boolean isInLevel(){
        int[] inLevel = {0x164};
        return Memory.read(inLevel, 1).getByte(0) != 0;
    }

    public static Thread onEnterLevel(Function function){
        Thread a = new Thread(() ->{
            boolean lastIsInLevel = false;
            while(true) {
                boolean isInLevel = isInLevel();
                if(isInLevel && !lastIsInLevel){
                    waitForLevel();
                    lastIsInLevel = true;
                    function.run();
                }
                if(!isInLevel) lastIsInLevel = false;
                Utilities.sleep(1);
            }
        });
        a.start();
        return a;
    }

    public static void waitForLevel(){
        do {
            Utilities.sleep(100);

        } while (Level.getLevelName() == null);
    }

    public static Thread onLeaveLevel(Function function){
        Thread a = new Thread(() ->{
            boolean lastIsntInLevel = false;
            while(true) {
                boolean isInLevel = isInLevel();
                if (!isInLevel && !lastIsntInLevel) {
                    lastIsntInLevel = true;
                    function.run();
                }
                if (isInLevel) lastIsntInLevel = false;
                Utilities.sleep(1);
            }
        });
        a.start();
        return a;
    }

    public static boolean isInEditor(){
        int[] inEditor = {0x168};
        return Memory.read(inEditor, 1).getByte(0) > 0;
    }

    public static Dimension getResolution(){
        int[] resolution = {0x2E0};

        int resolutionValue = Memory.read(resolution, 4).getInt(0);

        switch (resolutionValue){
            case 1: return new Dimension(640,480);
            case 2: return new Dimension(720,480);
            case 3: return new Dimension(720,576);
            case 4: return new Dimension(800,600);
            case 5: return new Dimension(1024,768);
            case 6: return new Dimension(1152,864);
            case 7: return new Dimension(1176,664);
            case 8: return new Dimension(1280,720);
            case 9: return new Dimension(1280,768);
            case 10: return new Dimension(1280,800);
            case 11: return new Dimension(1280,960);
            case 12: return new Dimension(1280,1024);
            case 13: return new Dimension(1360,768);
            case 14: return new Dimension(1366,768);
            case 15: return new Dimension(1440,900);
            case 16: return new Dimension(1600,900);
            case 17: return new Dimension(1600,1024);
            case 18: return new Dimension(1600,1200);
            case 19: return new Dimension(1690,1050);
            case 20: return new Dimension(1768,992);
            case 21: return new Dimension(1920,1080);
            case 22: return new Dimension(1920,1200);
            case 23: return new Dimension(1920,1440);
            case 24: return new Dimension(2560,1440);
        }
        return new Dimension(0,0);
    }
}
