package com.alphalaneous;

import com.alphalaneous.Interfaces.Function;

import java.util.ArrayList;
import java.util.Base64;
import java.util.LinkedHashMap;
import java.util.Map;

public class LevelExplorer {

    private static ArrayList<LevelData> levelData = new ArrayList<>();

    public static void doIfKeyExists(LinkedHashMap<String, Object> values, String key, Function function){

        if(function == null) return;
        if(values.containsKey(key)){
            function.run();
        }
    }

    public static ArrayList<LevelData> getLevelData(){
        return levelData;
    }

    public static void loadLevels(){
        if(SaveExplorer.getLocalLevels().containsValue("LLM_01")) {
            LinkedHashMap<String, Object> llm_01 = (LinkedHashMap<String, Object>) SaveExplorer.getLocalLevels().get("LLM_01");
            for (Map.Entry<String, Object> set : llm_01.entrySet()) {

                if (set.getValue() instanceof SaveValue) continue;
                LinkedHashMap<String, Object> level = (LinkedHashMap<String, Object>) set.getValue();

                LevelData data = new LevelData();

                data.setLevelKey(set.getKey());

                doIfKeyExists(level, "k1", () -> data.setLevelID(Integer.parseInt((String) ((SaveValue) level.get("k1")).value)));
                doIfKeyExists(level, "k2", () -> data.setLevelName((String) ((SaveValue) level.get("k2")).value));
                doIfKeyExists(level, "k3", () -> data.setDescription(new String(Base64.getUrlDecoder().decode(((String) ((SaveValue) level.get("k3")).value)))));
                doIfKeyExists(level, "k4", () -> data.setInnerLevelString((String) ((SaveValue) level.get("k4")).value));
                doIfKeyExists(level, "k5", () -> data.setCreator((String) ((SaveValue) level.get("k5")).value));
                doIfKeyExists(level, "k6", () -> data.setUserID(Integer.parseInt((String) ((SaveValue) level.get("k6")).value)));
                doIfKeyExists(level, "k7", () -> data.setLevelDifficulty(Integer.parseInt((String) ((SaveValue) level.get("k7")).value)));
                doIfKeyExists(level, "k8", () -> data.setOfficialSongID(Integer.parseInt((String) ((SaveValue) level.get("k8")).value)));
                doIfKeyExists(level, "k9", () -> data.setRating(Integer.parseInt((String) ((SaveValue) level.get("k9")).value)));
                doIfKeyExists(level, "k10", () -> data.setRatingSum(Integer.parseInt((String) ((SaveValue) level.get("k10")).value)));
                doIfKeyExists(level, "k11", () -> data.setDownloads(Integer.parseInt((String) ((SaveValue) level.get("k11")).value)));
                doIfKeyExists(level, "k12", () -> data.setSetCompletes(Integer.parseInt((String) ((SaveValue) level.get("k12")).value)));
                doIfKeyExists(level, "k13", () -> data.setEditable((Boolean) ((SaveValue) level.get("k13")).value));
                doIfKeyExists(level, "k14", () -> data.setVerified((Boolean) ((SaveValue) level.get("k14")).value));
                doIfKeyExists(level, "k15", () -> data.setUploaded((Boolean) ((SaveValue) level.get("k15")).value));
                doIfKeyExists(level, "k16", () -> data.setLevelVersion(Integer.parseInt((String) ((SaveValue) level.get("k16")).value)));
                doIfKeyExists(level, "k17", () -> data.setGameVersion(Integer.parseInt((String) ((SaveValue) level.get("k17")).value)));
                doIfKeyExists(level, "k18", () -> data.setAttempts(Integer.parseInt((String) ((SaveValue) level.get("k18")).value)));
                doIfKeyExists(level, "k19", () -> data.setNormalPercentage(Integer.parseInt((String) ((SaveValue) level.get("k19")).value)));
                doIfKeyExists(level, "k20", () -> data.setPracticePercentage(Integer.parseInt((String) ((SaveValue) level.get("k20")).value)));
                doIfKeyExists(level, "k21", () -> data.setLevelType(Integer.parseInt((String) ((SaveValue) level.get("k21")).value)));
                doIfKeyExists(level, "k22", () -> data.setLikeRating(Integer.parseInt((String) ((SaveValue) level.get("k22")).value)));
                doIfKeyExists(level, "k23", () -> data.setLength(Length.fromInteger(Integer.parseInt((String) ((SaveValue) level.get("k23")).value))));
                doIfKeyExists(level, "k24", () -> data.setDislikes(Integer.parseInt((String) ((SaveValue) level.get("k24")).value)));
                doIfKeyExists(level, "k25", () -> data.setDemon((Boolean) ((SaveValue) level.get("k25")).value));
                doIfKeyExists(level, "k26", () -> data.setStars(Integer.parseInt((String) ((SaveValue) level.get("k26")).value)));
                doIfKeyExists(level, "k27", () -> data.setFeatureScore(Integer.parseInt((String) ((SaveValue) level.get("k27")).value)));
                doIfKeyExists(level, "k33", () -> data.setAuto((Boolean) ((SaveValue) level.get("k33")).value));
                doIfKeyExists(level, "k36", () -> data.setTotalJumps(Integer.parseInt((String) ((SaveValue) level.get("k36")).value)));
                doIfKeyExists(level, "k41", () -> data.setPassword(Integer.parseInt((String) ((SaveValue) level.get("k41")).value)));
                doIfKeyExists(level, "k42", () -> data.setOriginal(Integer.parseInt((String) ((SaveValue) level.get("k42")).value)));
                doIfKeyExists(level, "k43", () -> data.setTwoPlayer((Boolean) ((SaveValue) level.get("k43")).value));
                doIfKeyExists(level, "k45", () -> data.setCustomSongID(Integer.parseInt((String) ((SaveValue) level.get("k45")).value)));
                doIfKeyExists(level, "k46", () -> data.setLevelRevision(Integer.parseInt((String) ((SaveValue) level.get("k46")).value)));
                doIfKeyExists(level, "k47", () -> data.setHasBeenModified((Boolean) ((SaveValue) level.get("k47")).value));
                doIfKeyExists(level, "k48", () -> data.setObjectCount(Integer.parseInt((String) ((SaveValue) level.get("k48")).value)));
                doIfKeyExists(level, "k60", () -> data.setAccountID(Integer.parseInt((String) ((SaveValue) level.get("k60")).value)));
                doIfKeyExists(level, "k61", () -> data.setFirstCoinAcquired((Boolean) ((SaveValue) level.get("k61")).value));
                doIfKeyExists(level, "k62", () -> data.setSecondCoinAcquired((Boolean) ((SaveValue) level.get("k62")).value));
                doIfKeyExists(level, "k63", () -> data.setThirdCoinAcquired((Boolean) ((SaveValue) level.get("k63")).value));
                doIfKeyExists(level, "k64", () -> data.setTotalCoins(Integer.parseInt((String) ((SaveValue) level.get("k64")).value)));
                doIfKeyExists(level, "k65", () -> data.setAreCoinsVerified((Boolean) ((SaveValue) level.get("k65")).value));
                doIfKeyExists(level, "k66", () -> data.setRequestedStars(Integer.parseInt((String) ((SaveValue) level.get("k66")).value)));
                doIfKeyExists(level, "k69", () -> data.setHasHighObjects((Boolean) ((SaveValue) level.get("k69")).value));
                doIfKeyExists(level, "k71", () -> data.setManaOrbPercentage(Integer.parseInt((String) ((SaveValue) level.get("k71")).value)));
                doIfKeyExists(level, "k72", () -> data.setHasLowDetailMode((Boolean) ((SaveValue) level.get("k72")).value));
                doIfKeyExists(level, "k73", () -> data.setToggleLDM((Boolean) ((SaveValue) level.get("k73")).value));
                doIfKeyExists(level, "k74", () -> data.setTimelyID(Integer.parseInt((String) ((SaveValue) level.get("k74")).value)));
                doIfKeyExists(level, "k75", () -> data.setEpic((Boolean) ((SaveValue) level.get("k75")).value));
                doIfKeyExists(level, "k76", () -> data.setDemonType(Integer.parseInt((String) ((SaveValue) level.get("k76")).value)));
                doIfKeyExists(level, "k77", () -> data.setGauntlet((Boolean) ((SaveValue) level.get("k77")).value));
                doIfKeyExists(level, "k79", () -> data.setUnlisted((Boolean) ((SaveValue) level.get("k79")).value));
                doIfKeyExists(level, "k80", () -> data.setSecondsSpentEditing(Integer.parseInt((String) ((SaveValue) level.get("k80")).value)));
                doIfKeyExists(level, "k81", () -> data.setCopiesSecondsSpentEditing(Integer.parseInt((String) ((SaveValue) level.get("k81")).value)));
                doIfKeyExists(level, "k82", () -> data.setFavorite((Boolean) ((SaveValue) level.get("k82")).value));
                doIfKeyExists(level, "k83", () -> data.setLevelOrder(Integer.parseInt((String) ((SaveValue) level.get("k83")).value)));
                doIfKeyExists(level, "k84", () -> data.setLevelFolder(Integer.parseInt((String) ((SaveValue) level.get("k84")).value)));
                doIfKeyExists(level, "k85", () -> data.setClicks(Integer.parseInt((String) ((SaveValue) level.get("k85")).value)));
                doIfKeyExists(level, "k86", () -> data.setPlayerTime(Integer.parseInt((String) ((SaveValue) level.get("k86")).value)));
                doIfKeyExists(level, "k87", () -> data.setLevelSeed(Integer.parseInt((String) ((SaveValue) level.get("k87")).value)));
                doIfKeyExists(level, "k88", () -> data.setLevelProgressString((String) ((SaveValue) level.get("k88")).value));
                doIfKeyExists(level, "k89", () -> data.setVfDChk((Boolean) ((SaveValue) level.get("k89")).value));
                doIfKeyExists(level, "k90", () -> data.setLeaderboardPercent(Integer.parseInt((String) ((SaveValue) level.get("k90")).value)));

                doIfKeyExists(level, "kI1", () -> data.setEditorCameraXPos(Float.parseFloat((String) ((SaveValue) level.get("kI1")).value)));
                doIfKeyExists(level, "kI2", () -> data.setEditorCameraYPos(Float.parseFloat((String) ((SaveValue) level.get("kI2")).value)));
                doIfKeyExists(level, "kI3", () -> data.setEditorCameraZoom(Float.parseFloat((String) ((SaveValue) level.get("kI3")).value)));
                doIfKeyExists(level, "kI4", () -> data.setBuildTabPage(Integer.parseInt((String) ((SaveValue) level.get("kI4")).value)));
                doIfKeyExists(level, "kI5", () -> data.setBuildTab(Integer.parseInt((String) ((SaveValue) level.get("kI5")).value)));
                doIfKeyExists(level, "kI7", () -> data.setEditorLayer(Float.parseFloat((String) ((SaveValue) level.get("kI7")).value)));
                doIfKeyExists(level, "kI6", () -> {
                    LinkedHashMap<String, Object> buildTabPagesDict = (LinkedHashMap<String, Object>) level.get("kI6");
                    LinkedHashMap<Integer, Integer> buildTabPages = new LinkedHashMap<>();
                    for (Map.Entry<String, Object> setA : buildTabPagesDict.entrySet()) {
                        buildTabPages.put(Integer.valueOf(setA.getKey()), Integer.valueOf(((String) ((SaveValue) setA.getValue()).value)));
                    }
                    data.setBuildTabPages(buildTabPages);
                });
                levelData.add(data);
            }
        }
    }


    public static void updateLevel(LevelData data){
        LinkedHashMap<String, Object> llm_01 = (LinkedHashMap<String, Object>) SaveExplorer.getLocalLevels().get("LLM_01");

        for (Map.Entry<String, Object> set : llm_01.entrySet()) {

            if(set.getKey().equalsIgnoreCase(data.getLevelKey())) {
                ((LinkedHashMap<String, Object>) SaveExplorer.getLocalLevels().get("LLM_01")).put(data.getLevelKey(), data.getDataMap());
                break;
            }
        }
    }

    public static LevelData getLevelByName(String name){
        return getLevelByName(name, 0, false);
    }

    public static LevelData getLevelByName(String name, boolean caseSensitive){
        return getLevelByName(name, 0, caseSensitive);
    }

    public static LevelData getLevelByName(String name, int rev){
        return getLevelByName(name, rev, false);
    }

    public static LevelData getLevelByName(String name, int rev, boolean caseSensitive){

        LevelData level = null;

        for(LevelData data : levelData){
            boolean isLevel = false;

            if(caseSensitive) {
                if (data.levelName.equals(name)) {
                    isLevel = true;
                }
            }
            else{
                if (data.levelName.equalsIgnoreCase(name)) {
                    isLevel = true;
                }
            }
            int revision = 0;

            if(rev != 0) revision = data.levelRevision;
            if(isLevel) level = data;
            if(revision == rev && isLevel) return level;

        }
        return null;
    }
}
