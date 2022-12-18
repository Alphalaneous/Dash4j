package com.alphalaneous.Servers;

import com.alphalaneous.Encoding;
import com.alphalaneous.Length;
import com.alphalaneous.Utilities;

import java.util.Collections;
import java.util.LinkedHashMap;

public class LevelFilter {

    int type = 0;
    String searchString = null;
    int difficultyFilter = 0;
    boolean hasDifficultyFilter = false;
    int length = 0;
    boolean hasLengthFilter = false;
    int uncompletedFilter = 0;
    int completedFilter = 0;
    int featuredFilter = 0;
    int originalFilter = 0;
    int twoPlayerFilter = 0;
    int coinFilter = 0;
    int epicFilter = 0;
    int noStarFilter = 0;
    int ratedFilter = 0;
    int songFilter = 0;
    int customSongFilter = 0;
    long[] followedFilterPlayerIDs;
    long[] completedLevels;
    long accountID;
    String password;
    int gauntletID = -1;

    int demonFilter = 0;

    public void setType(Type type){
        this.type = type.toInt();
    }

    public void setDifficulty(Difficulty difficulty){
        this.difficultyFilter = difficulty.toInt();
        this.hasDifficultyFilter = true;
    }

    public void setLength(Length length){
        this.length = length.toInt();
        this.hasLengthFilter = true;
    }

    public void setSearchString(String searchString){
        this.searchString = searchString;
    }

    public void setUncompletedFilter(boolean value){
        this.uncompletedFilter = value ? 1 : 0;
    }

    public void setCompletedFilter(boolean value){
        this.completedFilter = value ? 1 : 0;
    }

    public void setFeaturedFilter(boolean value){
        this.featuredFilter = value ? 1 : 0;
    }

    public void setOriginalFilter(boolean value){
        this.originalFilter = value ? 1 : 0;
    }

    public void setTwoPlayerFilter(boolean value){
        this.twoPlayerFilter = value ? 1 : 0;
    }

    public void setCoinFilter(boolean value){
        this.coinFilter = value ? 1 : 0;
    }

    public void setEpicFilter(boolean value){
        this.epicFilter = value ? 1 : 0;
    }

    public void setNoStarFilter(boolean value){
        this.noStarFilter = value ? 1 : 0;
    }

    public void setRatedFilter(boolean value){
        this.ratedFilter = value ? 1 : 0;
    }

    public void setDemonFilter(boolean value){
        this.demonFilter = value ? 1 : 0;
    }

    public void setSongFilter(int value){
        this.songFilter = value;
    }

    public void setCustomSongFilter(int value){
        this.customSongFilter = value;
    }

    public void setFollowedFilterPlayerIDs(long... playerIDs){
        this.followedFilterPlayerIDs = playerIDs;
    }

    public void setCompletedLevels(long... completedLevels){
        this.completedLevels = completedLevels;
    }

    public void setAccountID(long accountID){
        this.accountID = accountID;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public void setGauntletID(int gauntletID){
        this.gauntletID = gauntletID;
    }


    public LinkedHashMap<String, String> toValueMap(){

        LinkedHashMap<String, String> values = new LinkedHashMap<>();
        values.put("type", String.valueOf(type));
        if(searchString != null) values.put("str", searchString);
        if(hasDifficultyFilter) values.put("diff", String.valueOf(difficultyFilter));
        if(hasLengthFilter) values.put("len", String.valueOf(length));
        values.put("uncompleted", String.valueOf(uncompletedFilter));
        values.put("onlyCompleted", String.valueOf(completedFilter));
        values.put("featured", String.valueOf(featuredFilter));
        values.put("original", String.valueOf(originalFilter));
        values.put("twoPlayer", String.valueOf(twoPlayerFilter));
        values.put("coins", String.valueOf(coinFilter));
        values.put("epic", String.valueOf(epicFilter));
        if(noStarFilter != 0) values.put("noStar", String.valueOf(noStarFilter));
        if(songFilter != 0) values.put("song", String.valueOf(songFilter));
        if(customSongFilter != 0) values.put("customSong", String.valueOf(customSongFilter));
        if(type == 5 || type == 8 || type == 13) {
            values.put("accountID", String.valueOf(accountID));
            values.put("gjp", Encoding.generateGJP(password));
        }
        if(gauntletID != -1) values.put("gauntlet", String.valueOf(gauntletID));

        String commaSeparatedLevelIDs = "[" + Utilities.join(',', Collections.singletonList(completedLevels).toArray(new Long[completedLevels.length])) + "]";

        if(uncompletedFilter == 1 || completedFilter == 1) values.put("completedLevels", commaSeparatedLevelIDs);

        String commaSeparatedPlayerIDs = Utilities.join(',', Collections.singletonList(followedFilterPlayerIDs).toArray(new Long[followedFilterPlayerIDs.length]));

        if(type == 12) values.put("followed", commaSeparatedPlayerIDs);
        if(difficultyFilter == -2 && demonFilter != 0) values.put("demonFilter", String.valueOf(demonFilter));

        return values;
    }

}
