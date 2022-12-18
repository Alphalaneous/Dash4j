package com.alphalaneous;

public class ColorProperties {

    private int fromColorRed = 255;
    private int fromColorGreen = 255;
    private int fromColorBlue = 255;
    private PlayerColor playerColor = PlayerColor.NONE;
    private boolean blending = false;
    private int colorChannelIndex = 0;
    private float fromOpacity = 0;
    private boolean toggleOpacity = false;
    private int inheritedColorChannelIndex = 0;
    private HSV hsv = HSV.DEFAULT;
    private int toColorRed = 255;
    private int toColorGreen = 255;
    private int toColorBlue = 255;
    private float deltaTime = 0;
    private float toOpacity = 0;
    private float duration = 0;
    private boolean copyOpacity = false;
    private boolean unknown18 = false;

    public int getFromColorRed() {
        return fromColorRed;
    }

    public void setFromColorRed(int fromColorRed) {
        this.fromColorRed = fromColorRed;
    }

    public int getFromColorGreen() {
        return fromColorGreen;
    }

    public void setFromColorGreen(int fromColorGreen) {
        this.fromColorGreen = fromColorGreen;
    }

    public int getFromColorBlue() {
        return fromColorBlue;
    }

    public void setFromColorBlue(int fromColorBlue) {
        this.fromColorBlue = fromColorBlue;
    }

    public PlayerColor getPlayerColor() {
        return playerColor;
    }

    public void setPlayerColor(PlayerColor playerColor) {
        this.playerColor = playerColor;
    }

    public boolean isBlending() {
        return blending;
    }

    public void setBlending(boolean blending) {
        this.blending = blending;
    }

    public int getColorChannelIndex() {
        return colorChannelIndex;
    }

    public void setColorChannelIndex(int colorChannelIndex) {
        this.colorChannelIndex = colorChannelIndex;
    }

    public float getFromOpacity() {
        return fromOpacity;
    }

    public void setFromOpacity(float fromOpacity) {
        this.fromOpacity = fromOpacity;
    }

    public boolean isToggleOpacity() {
        return toggleOpacity;
    }

    public void setToggleOpacity(boolean toggleOpacity) {
        this.toggleOpacity = toggleOpacity;
    }

    public int getInheritedColorChannelIndex() {
        return inheritedColorChannelIndex;
    }

    public void setInheritedColorChannelIndex(int inheritedColorChannelIndex) {
        this.inheritedColorChannelIndex = inheritedColorChannelIndex;
    }

    public HSV getHsv() {
        return hsv;
    }

    public void setHsv(HSV hsv) {
        this.hsv = hsv;
    }

    public int getToColorRed() {
        return toColorRed;
    }

    public void setToColorRed(int toColorRed) {
        this.toColorRed = toColorRed;
    }

    public int getToColorGreen() {
        return toColorGreen;
    }

    public void setToColorGreen(int toColorGreen) {
        this.toColorGreen = toColorGreen;
    }

    public int getToColorBlue() {
        return toColorBlue;
    }

    public void setToColorBlue(int toColorBlue) {
        this.toColorBlue = toColorBlue;
    }

    public float getDeltaTime() {
        return deltaTime;
    }

    public void setDeltaTime(float deltaTime) {
        this.deltaTime = deltaTime;
    }

    public float getToOpacity() {
        return toOpacity;
    }

    public void setToOpacity(float toOpacity) {
        this.toOpacity = toOpacity;
    }

    public float getDuration() {
        return duration;
    }

    public void setDuration(float duration) {
        this.duration = duration;
    }

    public boolean isCopyOpacity() {
        return copyOpacity;
    }

    public void setCopyOpacity(boolean copyOpacity) {
        this.copyOpacity = copyOpacity;
    }

    public boolean isUnknown18() {
        return unknown18;
    }

    public void setUnknown18(boolean unknown18) {
        this.unknown18 = unknown18;
    }


    public String toString(){

        StringBuilder builder = new StringBuilder();
        append(builder, fromColorRed, 1);
        append(builder, fromColorGreen, 2);
        append(builder, fromColorBlue, 3);
        append(builder, playerColor.toInt(), 4);
        append(builder, blending, 5);
        append(builder, colorChannelIndex, 6);
        append(builder, fromOpacity, 7);
        append(builder, toggleOpacity, 8);
        append(builder, inheritedColorChannelIndex, 9);
        append(builder, hsv.toString(), 10);
        append(builder, toColorRed, 11);
        append(builder, toColorGreen, 12);
        append(builder, toColorBlue, 13);
        append(builder, deltaTime, 14);
        append(builder, toOpacity, 15);
        append(builder, duration, 16);
        append(builder, copyOpacity, 17);
        append(builder, unknown18, 18);

        return builder.substring(0, builder.length()-1);

    }

    public void append(StringBuilder builder, Object value, int key){

        builder.append(Utilities.toPair(String.valueOf(key), value, '_'));

    }


}
