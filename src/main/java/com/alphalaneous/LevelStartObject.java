package com.alphalaneous;

public class LevelStartObject {

    private int audioTrack = 0;
    private Gamemode gamemode = Gamemode.CUBE;
    private boolean isMiniMode = false;
    private Speed speed = Speed.NORMAL;
    private int backgroundTextureID = 0;
    private int groundTextureID = 0;
    private boolean dualMode = false;
    private boolean isStartPosObject = false;
    private boolean isTwoPlayerMode = false;
    private boolean flipGravity = false;
    private float songOffset = 0;
    private GuidelineString guidelines;
    private boolean fadeIn = false;
    private boolean fadeOut = false;
    private int groundLineID = 0;
    private int fontID = 0;
    private boolean isPlatformer;
    private ColorString colors = new ColorString();
    private int colorPage = 0;

    public int getAudioTrack() {
        return audioTrack;
    }

    public void setAudioTrack(int audioTrack) {
        this.audioTrack = audioTrack;
    }

    public Gamemode getGamemode() {
        return gamemode;
    }

    public void setGamemode(Gamemode gamemode) {
        this.gamemode = gamemode;
    }

    public boolean isMiniMode() {
        return isMiniMode;
    }

    public void setMiniMode(boolean miniMode) {
        isMiniMode = miniMode;
    }

    public Speed getSpeed() {
        return speed;
    }

    public void setSpeed(Speed speed) {
        this.speed = speed;
    }

    public int getBackgroundTextureID() {
        return backgroundTextureID;
    }

    public void setBackgroundTextureID(int backgroundTextureID) {
        this.backgroundTextureID = backgroundTextureID;
    }

    public int getGroundTextureID() {
        return groundTextureID;
    }

    public void setGroundTextureID(int groundTextureID) {
        this.groundTextureID = groundTextureID;
    }

    public boolean isDualMode() {
        return dualMode;
    }

    public void setDualMode(boolean dualMode) {
        this.dualMode = dualMode;
    }

    public boolean isStartPosObject() {
        return isStartPosObject;
    }

    public void setStartPosObject(boolean startPosObject) {
        isStartPosObject = startPosObject;
    }

    public boolean isTwoPlayerMode() {
        return isTwoPlayerMode;
    }

    public void setTwoPlayerMode(boolean twoPlayerMode) {
        isTwoPlayerMode = twoPlayerMode;
    }

    public boolean isFlipGravity() {
        return flipGravity;
    }

    public void setFlipGravity(boolean flipGravity) {
        this.flipGravity = flipGravity;
    }

    public float getSongOffset() {
        return songOffset;
    }

    public void setSongOffset(float songOffset) {
        this.songOffset = songOffset;
    }

    public GuidelineString getGuidelines() {
        return guidelines;
    }

    public void setGuidelines(GuidelineString guidelines) {
        this.guidelines = guidelines;
    }

    public boolean isFadeIn() {
        return fadeIn;
    }

    public void setFadeIn(boolean fadeIn) {
        this.fadeIn = fadeIn;
    }

    public boolean isFadeOut() {
        return fadeOut;
    }

    public void setFadeOut(boolean fadeOut) {
        this.fadeOut = fadeOut;
    }

    public int getGroundLineID() {
        return groundLineID;
    }

    public void setGroundLineID(int groundLineID) {
        this.groundLineID = groundLineID;
    }

    public int getFontID() {
        return fontID;
    }

    public void setFontID(int fontID) {
        this.fontID = fontID;
    }

    public boolean isPlatformer() {
        return isPlatformer;
    }

    public void setPlatformer(boolean platformer) {
        isPlatformer = platformer;
    }

    public ColorString getColors() {
        return colors;
    }

    public void setColors(ColorString colors) {
        this.colors = colors;
    }

    public int getColorPage() {
        return colorPage;
    }

    public void setColorPage(int colorPage) {
        this.colorPage = colorPage;
    }

    public String toString(){

        StringBuilder builder = new StringBuilder();
        builder.append(toPair("kA1", audioTrack));
        builder.append(toPair("kA2", gamemode.toInt()));
        builder.append(toPair("kA3", isMiniMode));
        builder.append(toPair("kA4", speed.toInt()));
        builder.append(toPair("kA6", backgroundTextureID));
        builder.append(toPair("kA7", groundTextureID));
        builder.append(toPair("kA8", dualMode));
        builder.append(toPair("kA9", isStartPosObject));
        builder.append(toPair("kA10", isTwoPlayerMode));
        builder.append(toPair("kA11", flipGravity));
        builder.append(toPair("kA13", songOffset));
        appendIfExists(builder, guidelines, "kA14");
        builder.append(toPair("kA15", fadeIn));
        builder.append(toPair("kA16", fadeOut));
        builder.append(toPair("kA17", groundLineID));
        builder.append(toPair("kA18", fontID));
        appendIfExists(builder, isPlatformer, "kA22");
        builder.append(toPair("kS38", colors.toString()));
        builder.append(toPair("kS39", colorPage));

        return builder.substring(0, builder.length()-1);
    }

    public void appendIfExists(StringBuilder builder, Object value, String key){
        Utilities.appendIfExists(builder, value, key, ',');
    }

    public String toPair(String ID, Object value){

        if(value instanceof Boolean){
            value = Utilities.boolToInt((Boolean) value);
        }

        return Utilities.toPair(ID, value, ',');
    }

}
