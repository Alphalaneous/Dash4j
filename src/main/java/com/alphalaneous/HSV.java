package com.alphalaneous;

public class HSV {

    float h, s, v = 0;
    boolean sChecked, vChecked = false;

    public HSV(float h, float s, float v, boolean sChecked, boolean vChecked){
        this.h = h;
        this.s = s;
        this.v = v;
        this.sChecked = sChecked;
        this.vChecked = vChecked;
    }

    public static HSV DEFAULT = new HSV(0, 1, 1, false, false);

    public float getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public float getS() {
        return s;
    }

    public void setS(int s) {
        this.s = s;
    }

    public float getV() {
        return v;
    }

    public void setV(int v) {
        this.v = v;
    }

    public boolean isSChecked() {
        return sChecked;
    }

    public void setSChecked(boolean sChecked) {
        this.sChecked = sChecked;
    }

    public boolean isVChecked() {
        return vChecked;
    }

    public void setVChecked(boolean vChecked) {
        this.vChecked = vChecked;
    }

    public String toString(){

        return h + "a" + s + "a" + v + "a" + Utilities.boolToInt(sChecked) + "a" + Utilities.boolToInt(vChecked);

    }
}
