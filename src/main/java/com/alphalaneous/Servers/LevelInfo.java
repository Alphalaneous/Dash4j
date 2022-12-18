package com.alphalaneous.Servers;

import com.alphalaneous.Encoding;
import com.alphalaneous.Length;
import com.alphalaneous.Utilities;

import java.util.ArrayList;
import java.util.Base64;
import java.util.LinkedHashMap;

public class LevelInfo {

    int gameVersion;
    long levelID;
    String levelName;
    String levelDesc;
    int levelVersion;
    int levelLength;
    int audioTrack = 0;
    int auto = 0;
    int password = 0;
    long original = 0;
    int twoPlayer = 0;
    long songID = 0;
    long objects = 0;
    int coins = 0;
    int requestedStars = 0;
    int unlisted = 0;
    int ldm = 0;
    String levelString;


    public void setGameVersion(int gameVersion){
        this.gameVersion = gameVersion;
    }

    public void setLevelID(long levelID){
        this.levelID = levelID;
    }

    public void setLevelName(String levelName){
        this.levelName = levelName;
    }

    public void setLevelDesc(String levelDesc){
        this.levelDesc = levelDesc;
    }

    public void setLevelVersion(int levelVersion){
        this.levelVersion = levelVersion;
    }

    public void setLevelLength(Length length){
        this.levelLength = length.toInt();
    }

    public void setAudioTrack(int audioTrack){
        this.audioTrack = audioTrack;
    }

    public void setPassword(int password){
        this.password = password;
    }

    public void setOriginal(long original){
        this.original = original;
    }

    public void setTwoPlayer(boolean twoPlayer){
        this.twoPlayer = twoPlayer ? 1 : 0;
    }

    public void setSongID(long songID){
        this.songID = songID;
    }

    public void setObjects(long objects){
        this.objects = objects;
    }

    public void setCoins(int coins){
        this.coins = coins;
    }

    public void setRequestedStars(int requestedStars){
        this.requestedStars = requestedStars;
    }

    public void setUnlisted(boolean unlisted){
        this.unlisted = unlisted ? 1 : 0;
    }

    public void setLDM(boolean ldm){
        this.ldm = ldm ? 1 : 0;
    }

    public void setLevelString(String levelString){
        this.levelString = levelString;
    }

    public String getCompressedLevelString(){
        return Base64.getUrlEncoder().encodeToString(Utilities.compress(levelString));
    }

    public String generateSeed2(){

        ArrayList<String> values = new ArrayList<>();
        values.add(generateUploadSeed());

        return Encoding.generateCHK(41274, values, "xI25fpAapCQg");
    }

    public String generateUploadSeed(){

        String compressedLevelString = getCompressedLevelString();

        if(compressedLevelString.length() < 50){
            return compressedLevelString;
        }

        StringBuilder value = new StringBuilder();

        for(int i = 0; i < 50; i++){
            value.append(compressedLevelString.charAt((compressedLevelString.length() / 50) * i));
        }

        return value.toString();
    }

    public LinkedHashMap<String, String> toValueMap(){

        LinkedHashMap<String, String> values = new LinkedHashMap<>();
        values.put("gameVersion", String.valueOf(gameVersion));
        values.put("levelID", String.valueOf(levelID));
        values.put("levelName", levelName);
        values.put("levelDesc", Base64.getUrlEncoder().encodeToString(levelDesc.getBytes()));
        values.put("levelVersion", String.valueOf(levelVersion));
        values.put("levelLength", String.valueOf(levelLength));
        values.put("audioTrack", String.valueOf(audioTrack));
        values.put("auto", String.valueOf(auto));
        values.put("password", String.valueOf(password));
        values.put("original", String.valueOf(original));
        values.put("twoPlayer", String.valueOf(twoPlayer));
        values.put("songID", String.valueOf(songID));
        values.put("objects", String.valueOf(objects));
        values.put("coins", String.valueOf(coins));
        values.put("requestedStars", String.valueOf(requestedStars));
        values.put("unlisted", String.valueOf(unlisted));
        values.put("ldm", String.valueOf(ldm));
        values.put("levelString", getCompressedLevelString());
        values.put("seed2", generateSeed2());

        return values;
    }



}
