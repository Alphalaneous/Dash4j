package com.alphalaneous;

import java.util.Base64;
import java.util.LinkedHashMap;
import java.util.Map;

public class LevelData {

    public int getLevelID() {
        return levelID;
    }

    public void setLevelID(int levelID) {
        this.levelID = levelID;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInnerLevelString() {
        return innerLevelString;
    }

    public void setInnerLevelString(String innerLevelString) {
        this.innerLevelString = innerLevelString;
    }

    public void setAndEncodeInnerLevelString(String innerLevelString) {
        this.innerLevelString = Base64.getUrlEncoder().encodeToString(Utilities.compress(innerLevelString));
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getLevelDifficulty() {
        return levelDifficulty;
    }

    public void setLevelDifficulty(int levelDifficulty) {
        this.levelDifficulty = levelDifficulty;
    }

    public int getOfficialSongID() {
        return officialSongID;
    }

    public void setOfficialSongID(int officialSongID) {
        this.officialSongID = officialSongID;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getRatingSum() {
        return ratingSum;
    }

    public void setRatingSum(int ratingSum) {
        this.ratingSum = ratingSum;
    }

    public int getDownloads() {
        return downloads;
    }

    public void setDownloads(int downloads) {
        this.downloads = downloads;
    }

    public int getSetCompletes() {
        return setCompletes;
    }

    public void setSetCompletes(int setCompletes) {
        this.setCompletes = setCompletes;
    }

    public boolean isEditable() {
        return isEditable;
    }

    public void setEditable(boolean editable) {
        isEditable = editable;
    }

    public boolean isVerified() {
        return isVerified;
    }

    public void setVerified(boolean verified) {
        isVerified = verified;
    }

    public boolean isUploaded() {
        return isUploaded;
    }

    public void setUploaded(boolean uploaded) {
        isUploaded = uploaded;
    }

    public int getLevelVersion() {
        return levelVersion;
    }

    public void setLevelVersion(int levelVersion) {
        this.levelVersion = levelVersion;
    }

    public int getGameVersion() {
        return gameVersion;
    }

    public void setGameVersion(int gameVersion) {
        this.gameVersion = gameVersion;
    }

    public int getAttempts() {
        return attempts;
    }

    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }

    public int getNormalPercentage() {
        return normalPercentage;
    }

    public void setNormalPercentage(int normalPercentage) {
        this.normalPercentage = normalPercentage;
    }

    public int getPracticePercentage() {
        return practicePercentage;
    }

    public void setPracticePercentage(int practicePercentage) {
        this.practicePercentage = practicePercentage;
    }

    public int getLevelType() {
        return levelType;
    }

    public void setLevelType(int levelType) {
        this.levelType = levelType;
    }

    public int getLikeRating() {
        return likeRating;
    }

    public void setLikeRating(int likeRating) {
        this.likeRating = likeRating;
    }

    public Length getLength() {
        return length;
    }

    public void setLength(Length length) {
        this.length = length;
    }

    public int getDislikes() {
        return dislikes;
    }

    public void setDislikes(int dislikes) {
        this.dislikes = dislikes;
    }

    public boolean isDemon() {
        return isDemon;
    }

    public void setDemon(boolean demon) {
        isDemon = demon;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public int getFeatureScore() {
        return featureScore;
    }

    public void setFeatureScore(int featureScore) {
        this.featureScore = featureScore;
    }

    public boolean isAuto() {
        return isAuto;
    }

    public void setAuto(boolean auto) {
        isAuto = auto;
    }

    public int getTotalJumps() {
        return totalJumps;
    }

    public void setTotalJumps(int totalJumps) {
        this.totalJumps = totalJumps;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public int getOriginal() {
        return original;
    }

    public void setOriginal(int original) {
        this.original = original;
    }

    public boolean isTwoPlayer() {
        return isTwoPlayer;
    }

    public void setTwoPlayer(boolean twoPlayer) {
        isTwoPlayer = twoPlayer;
    }

    public int getCustomSongID() {
        return customSongID;
    }

    public void setCustomSongID(int customSongID) {
        this.customSongID = customSongID;
    }

    public int getLevelRevision() {
        return levelRevision;
    }

    public void setLevelRevision(int levelRevision) {
        this.levelRevision = levelRevision;
    }

    public boolean isHasBeenModified() {
        return hasBeenModified;
    }

    public void setHasBeenModified(boolean hasBeenModified) {
        this.hasBeenModified = hasBeenModified;
    }

    public int getObjectCount() {
        return objectCount;
    }

    public void setObjectCount(int objectCount) {
        this.objectCount = objectCount;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public boolean isFirstCoinAcquired() {
        return firstCoinAcquired;
    }

    public void setFirstCoinAcquired(boolean firstCoinAcquired) {
        this.firstCoinAcquired = firstCoinAcquired;
    }

    public boolean isSecondCoinAcquired() {
        return secondCoinAcquired;
    }

    public void setSecondCoinAcquired(boolean secondCoinAcquired) {
        this.secondCoinAcquired = secondCoinAcquired;
    }

    public boolean isThirdCoinAcquired() {
        return thirdCoinAcquired;
    }

    public void setThirdCoinAcquired(boolean thirdCoinAcquired) {
        this.thirdCoinAcquired = thirdCoinAcquired;
    }

    public int getTotalCoins() {
        return totalCoins;
    }

    public void setTotalCoins(int totalCoins) {
        this.totalCoins = totalCoins;
    }

    public boolean isAreCoinsVerified() {
        return areCoinsVerified;
    }

    public void setAreCoinsVerified(boolean areCoinsVerified) {
        this.areCoinsVerified = areCoinsVerified;
    }

    public int getRequestedStars() {
        return requestedStars;
    }

    public void setRequestedStars(int requestedStars) {
        this.requestedStars = requestedStars;
    }

    public boolean isHasHighObjects() {
        return hasHighObjects;
    }

    public void setHasHighObjects(boolean hasHighObjects) {
        this.hasHighObjects = hasHighObjects;
    }

    public int getManaOrbPercentage() {
        return manaOrbPercentage;
    }

    public void setManaOrbPercentage(int manaOrbPercentage) {
        this.manaOrbPercentage = manaOrbPercentage;
    }

    public boolean isHasLowDetailMode() {
        return hasLowDetailMode;
    }

    public void setHasLowDetailMode(boolean hasLowDetailMode) {
        this.hasLowDetailMode = hasLowDetailMode;
    }

    public boolean isToggleLDM() {
        return toggleLDM;
    }

    public void setToggleLDM(boolean toggleLDM) {
        this.toggleLDM = toggleLDM;
    }

    public int getTimelyID() {
        return timelyID;
    }

    public void setTimelyID(int timelyID) {
        this.timelyID = timelyID;
    }

    public boolean isEpic() {
        return isEpic;
    }

    public void setEpic(boolean epic) {
        isEpic = epic;
    }

    public int getDemonType() {
        return demonType;
    }

    public void setDemonType(int demonType) {
        this.demonType = demonType;
    }

    public boolean isGauntlet() {
        return isGauntlet;
    }

    public void setGauntlet(boolean gauntlet) {
        isGauntlet = gauntlet;
    }

    public boolean isUnlisted() {
        return isUnlisted;
    }

    public void setUnlisted(boolean unlisted) {
        isUnlisted = unlisted;
    }

    public int getSecondsSpentEditing() {
        return secondsSpentEditing;
    }

    public void setSecondsSpentEditing(int secondsSpentEditing) {
        this.secondsSpentEditing = secondsSpentEditing;
    }

    public int getCopiesSecondsSpentEditing() {
        return copiesSecondsSpentEditing;
    }

    public void setCopiesSecondsSpentEditing(int copiesSecondsSpentEditing) {
        this.copiesSecondsSpentEditing = copiesSecondsSpentEditing;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }

    public int getLevelOrder() {
        return levelOrder;
    }

    public void setLevelOrder(int levelOrder) {
        this.levelOrder = levelOrder;
    }

    public int getLevelFolder() {
        return levelFolder;
    }

    public void setLevelFolder(int levelFolder) {
        this.levelFolder = levelFolder;
    }

    public int getClicks() {
        return clicks;
    }

    public void setClicks(int clicks) {
        this.clicks = clicks;
    }

    public int getPlayerTime() {
        return playerTime;
    }

    public void setPlayerTime(int playerTime) {
        this.playerTime = playerTime;
    }

    public int getLevelSeed() {
        return levelSeed;
    }

    public void setLevelSeed(int levelSeed) {
        this.levelSeed = levelSeed;
    }

    public String getLevelProgressString() {
        return levelProgressString;
    }

    public void setLevelProgressString(String levelProgressString) {
        this.levelProgressString = levelProgressString;
    }

    public boolean isVfDChk() {
        return vfDChk;
    }

    public void setVfDChk(boolean vfDChk) {
        this.vfDChk = vfDChk;
    }

    public int getLeaderboardPercent() {
        return leaderboardPercent;
    }

    public void setLeaderboardPercent(int leaderboardPercent) {
        this.leaderboardPercent = leaderboardPercent;
    }

    public float getEditorCameraXPos() {
        return editorCameraXPos;
    }

    public void setEditorCameraXPos(float editorCameraXPos) {
        this.editorCameraXPos = editorCameraXPos;
    }

    public float getEditorCameraYPos() {
        return editorCameraYPos;
    }

    public void setEditorCameraYPos(float editorCameraYPos) {
        this.editorCameraYPos = editorCameraYPos;
    }

    public float getEditorCameraZoom() {
        return editorCameraZoom;
    }

    public void setEditorCameraZoom(float editorCameraZoom) {
        this.editorCameraZoom = editorCameraZoom;
    }

    public int getBuildTabPage() {
        return buildTabPage;
    }

    public void setBuildTabPage(int buildTabPage) {
        this.buildTabPage = buildTabPage;
    }

    public int getBuildTab() {
        return buildTab;
    }

    public void setBuildTab(int buildTab) {
        this.buildTab = buildTab;
    }

    public LinkedHashMap<Integer, Integer> getBuildTabPages() {
        return buildTabPages;
    }

    public void setBuildTabPages(LinkedHashMap<Integer, Integer> buildTabPages) {
        this.buildTabPages = buildTabPages;
    }

    public float getEditorLayer() {
        return editorLayer;
    }

    public void setEditorLayer(float editorLayer) {
        this.editorLayer = editorLayer;
    }

    public String getLevelKey() {
        return levelKey;
    }

    public void setLevelKey(String levelKey) {
        this.levelKey = levelKey;
    }

    String levelKey = "";
    int levelID = 0;
    String levelName = "";
    String description = "";
    String innerLevelString = "";
    String creator = "";
    int userID = 0;
    int levelDifficulty = 0;
    int officialSongID = 0;
    int rating = 0;
    int ratingSum = 0;
    int downloads = 0;
    int setCompletes = 0;
    boolean isEditable = false;
    boolean isVerified = false;
    boolean isUploaded = false;
    int levelVersion = 0;
    int gameVersion = 0;
    int attempts = 0;
    int normalPercentage = 0;
    int practicePercentage = 0;
    int levelType = 0;
    int likeRating = 0;
    Length length = Length.TINY;
    int dislikes = 0;
    boolean isDemon = false;
    int stars = 0;
    int featureScore = 0;
    boolean isAuto = false;
    int totalJumps = 0;
    int password = 0;
    int original = 0;
    boolean isTwoPlayer = false;
    int customSongID = 0;
    int levelRevision = 0;
    boolean hasBeenModified = false;
    int objectCount = 0;
    int accountID = 0;
    boolean firstCoinAcquired = false;
    boolean secondCoinAcquired = false;
    boolean thirdCoinAcquired = false;
    int totalCoins = 0;
    boolean areCoinsVerified = false;
    int requestedStars = 0;
    boolean hasHighObjects = false;
    int manaOrbPercentage = 0;
    boolean hasLowDetailMode = false;
    boolean toggleLDM = false;
    int timelyID = 0;
    boolean isEpic = false;
    int demonType = 0;
    boolean isGauntlet = false;
    boolean isUnlisted = false;
    int secondsSpentEditing = 0;
    int copiesSecondsSpentEditing = 0;
    boolean isFavorite = false;
    int levelOrder = 0;
    int levelFolder = 0;
    int clicks = 0;
    int playerTime = 0;
    int levelSeed = 0;
    String levelProgressString = "";
    boolean vfDChk = false;
    int leaderboardPercent = 0;

    float editorCameraXPos = 0;
    float editorCameraYPos = 0;
    float editorCameraZoom = 0;
    int buildTabPage = 0;
    int buildTab = 0;
    LinkedHashMap<Integer, Integer> buildTabPages = new LinkedHashMap<>();
    float editorLayer = 0;


    public static void putIfNotEmpty(LinkedHashMap<String, Object> dataMap, String key, SaveValue saveValue){

        Object value = saveValue.value;

        String type = saveValue.type;

        if(type.equalsIgnoreCase("Integer")){
            if((Integer)value != 0) dataMap.put(key, value);
        }
        if(type.equalsIgnoreCase("Double")){
            if((Float)value != 0) dataMap.put(key, value);
        }
        if(type.equalsIgnoreCase("String")){
            if(!((String)value).equalsIgnoreCase("")) dataMap.put(key, value);
        }
        if(type.equalsIgnoreCase("Boolean")){
            if((Boolean) value) dataMap.put(key, value);
        }
    }


    public LinkedHashMap<String, Object> getDataMap(){

        LinkedHashMap<String, Object> dataMap = new LinkedHashMap<>();

        putIfNotEmpty(dataMap, "k1", new SaveValue('i', levelID));

        dataMap.put("k2", new SaveValue('s', levelName));
        dataMap.put("k3", new SaveValue('s', Base64.getUrlEncoder().encodeToString(description.getBytes())));

        dataMap.put("k4", new SaveValue('s', innerLevelString));
        dataMap.put("k5", new SaveValue('s', creator));
        dataMap.put("k6", new SaveValue('i', userID));
        dataMap.put("k16", new SaveValue('i', levelVersion));
        dataMap.put("k23", new SaveValue('i', length.toInt()));
        dataMap.put("k80", new SaveValue('i', secondsSpentEditing));
        dataMap.put("k83", new SaveValue('i', levelOrder));
        dataMap.put("k50", new SaveValue('i', 35));
        dataMap.put("k21", new SaveValue('i', levelType));
        dataMap.put("k13", new SaveValue('t', isEditable));
        dataMap.put("kCEK", new SaveValue('i', 4));
        dataMap.put("k18", new SaveValue('i', attempts));




        putIfNotEmpty(dataMap, "k7", new SaveValue('i', levelDifficulty));
        putIfNotEmpty(dataMap, "k8", new SaveValue('i', officialSongID));
        putIfNotEmpty(dataMap, "k9", new SaveValue('i', rating));
        putIfNotEmpty(dataMap, "k10", new SaveValue('i', ratingSum));
        putIfNotEmpty(dataMap, "k11", new SaveValue('i', downloads));
        putIfNotEmpty(dataMap, "k12", new SaveValue('i', setCompletes));
        putIfNotEmpty(dataMap, "k14", new SaveValue('t', isVerified));
        putIfNotEmpty(dataMap, "k15", new SaveValue('t', isUploaded));
        putIfNotEmpty(dataMap, "k17", new SaveValue('i', gameVersion));
        putIfNotEmpty(dataMap, "k19", new SaveValue('i', normalPercentage));
        putIfNotEmpty(dataMap, "k20", new SaveValue('i', practicePercentage));
        putIfNotEmpty(dataMap, "k22", new SaveValue('i', likeRating));
        putIfNotEmpty(dataMap, "k24", new SaveValue('i', dislikes));
        putIfNotEmpty(dataMap, "k25", new SaveValue('t', isDemon));
        putIfNotEmpty(dataMap, "k26", new SaveValue('i', stars));
        putIfNotEmpty(dataMap, "k27", new SaveValue('i', featureScore));
        putIfNotEmpty(dataMap, "k33", new SaveValue('t', isAuto));
        putIfNotEmpty(dataMap, "k36", new SaveValue('i', totalJumps));
        putIfNotEmpty(dataMap, "k41", new SaveValue('i', password));
        putIfNotEmpty(dataMap, "k42", new SaveValue('i', original));
        putIfNotEmpty(dataMap, "k43", new SaveValue('t', isTwoPlayer));
        putIfNotEmpty(dataMap, "k45", new SaveValue('i', customSongID));
        putIfNotEmpty(dataMap, "k46", new SaveValue('i', levelRevision));
        putIfNotEmpty(dataMap, "k47", new SaveValue('t', hasBeenModified));
        putIfNotEmpty(dataMap, "k48", new SaveValue('i', objectCount));
        putIfNotEmpty(dataMap, "k60", new SaveValue('i', accountID));
        putIfNotEmpty(dataMap, "k61", new SaveValue('t', firstCoinAcquired));
        putIfNotEmpty(dataMap, "k62", new SaveValue('t', secondCoinAcquired));
        putIfNotEmpty(dataMap, "k63", new SaveValue('t', thirdCoinAcquired));
        putIfNotEmpty(dataMap, "k64", new SaveValue('i', totalCoins));
        putIfNotEmpty(dataMap, "k65", new SaveValue('t', areCoinsVerified));
        putIfNotEmpty(dataMap, "k66", new SaveValue('i', requestedStars));
        putIfNotEmpty(dataMap, "k71", new SaveValue('i', manaOrbPercentage));
        putIfNotEmpty(dataMap, "k72", new SaveValue('t', hasLowDetailMode));
        putIfNotEmpty(dataMap, "k73", new SaveValue('t', toggleLDM));
        putIfNotEmpty(dataMap, "k74", new SaveValue('i', timelyID));
        putIfNotEmpty(dataMap, "k75", new SaveValue('t', isEpic));
        putIfNotEmpty(dataMap, "k76", new SaveValue('i', demonType));
        putIfNotEmpty(dataMap, "k77", new SaveValue('t', isGauntlet));
        putIfNotEmpty(dataMap, "k79", new SaveValue('t', isUnlisted));
        putIfNotEmpty(dataMap, "k81", new SaveValue('i', copiesSecondsSpentEditing));
        putIfNotEmpty(dataMap, "k82", new SaveValue('t', isFavorite));
        putIfNotEmpty(dataMap, "k84", new SaveValue('i', levelFolder));
        putIfNotEmpty(dataMap, "k85", new SaveValue('i', clicks));
        putIfNotEmpty(dataMap, "k86", new SaveValue('i', playerTime));
        putIfNotEmpty(dataMap, "k87", new SaveValue('i', levelSeed));
        putIfNotEmpty(dataMap, "k88", new SaveValue('s', levelProgressString));
        putIfNotEmpty(dataMap, "k89", new SaveValue('t', vfDChk));
        putIfNotEmpty(dataMap, "k90", new SaveValue('i', leaderboardPercent));

        dataMap.put("kI1", new SaveValue('r', editorCameraXPos));
        dataMap.put("kI2", new SaveValue('r', editorCameraYPos));
        dataMap.put("kI3", new SaveValue('r', editorCameraZoom));
        dataMap.put("kI4", new SaveValue('i', buildTabPage));
        dataMap.put("kI5", new SaveValue('i', buildTab));
        dataMap.put("kI7", new SaveValue('r', editorLayer));


        if(!buildTabPages.isEmpty()) {
            LinkedHashMap<String, Object> buildTabPagesDictionary = new LinkedHashMap<>();

            for (Map.Entry<Integer, Integer> set : buildTabPages.entrySet()) {
                SaveValue value = new SaveValue('s', set.getValue());
                buildTabPagesDictionary.put(String.valueOf(set.getKey()), value);
            }

            dataMap.put("kI6", buildTabPagesDictionary);
        }

        return dataMap;
    }

}
