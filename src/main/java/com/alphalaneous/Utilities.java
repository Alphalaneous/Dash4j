package com.alphalaneous;

import java.util.concurrent.TimeUnit;

public class Utilities {

    public static void sleep(int milliseconds){
        sleep(milliseconds, 0);
    }
    public static void sleep(int milliseconds, int nano){
        try {
            TimeUnit.MILLISECONDS.sleep(milliseconds);
            TimeUnit.NANOSECONDS.sleep(nano);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static float round(float value, int scale) {
        int pow = 10;
        for (int i = 1; i < scale; i++) {
            pow *= 10;
        }
        float tmp = value * pow;
        float tmpSub = tmp - (int) tmp;

        return ((float)((int)(value >= 0
                        ? (tmpSub >= 0.5f ? tmp + 1 : tmp)
                        : (tmpSub >= -0.5f ? tmp : tmp - 1)
        ))) / pow;
    }

    public static boolean isBetween(float val, float a, float b, float maxDiff){
        float temp;

        if(a > b){
            temp = a;
            a = b;
            b = temp;
        }

        if (b-a > maxDiff) return false;

        return val >= a && val <= b;
    }
}
