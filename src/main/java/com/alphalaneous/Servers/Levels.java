package com.alphalaneous.Servers;

import com.alphalaneous.Encoding;
import com.alphalaneous.Global;

import java.util.Base64;
import java.util.LinkedHashMap;
import java.util.Objects;

public class Levels {


    public static boolean deleteGJLevelUser20(long accountID, String password, long levelID){
        LinkedHashMap<String, String> values = new LinkedHashMap<>();
        values.put("accountID", String.valueOf(accountID));
        values.put("gjp", Encoding.generateGJP(password));
        values.put("levelID", String.valueOf(levelID));
        values.put("secret", Global.SECRET);

        String success = Server.request("deleteGJLevelUser20", values);
        return Objects.equals(success, "1");

    }

    public static String downloadGJLevel22(long levelID){
        LinkedHashMap<String, String> values = new LinkedHashMap<>();
        values.put("levelID", String.valueOf(levelID));
        values.put("secret", Global.SECRET);

        return Server.request("downloadGJLevel22", values);

    }

    public static String getGJDailyLevel(boolean weekly){

        LinkedHashMap<String, String> values = new LinkedHashMap<>();
        values.put("weekly", String.valueOf(weekly ? 1 : 0));
        values.put("secret", Global.SECRET);

        return Server.request("getGJDailyLevel", values);

    }

    public static String getGJLevels21(LevelFilter filter, int page){

        LinkedHashMap<String, String> values = new LinkedHashMap<>(filter.toValueMap());
        values.put("page", String.valueOf(page));
        values.put("secret", Global.SECRET);

        return Server.request("getGJLevels21", values);

    }

    public static String getGJLevels21(int page){

        LinkedHashMap<String, String> values = new LinkedHashMap<>();
        values.put("page", String.valueOf(page));
        values.put("secret", Global.SECRET);

        return Server.request("getGJLevels21", values);

    }


    public static void rateGJDemon21(long levelID, int rating, long accountID, String password){

        LinkedHashMap<String, String> values = new LinkedHashMap<>();
        values.put("levelID", String.valueOf(levelID));
        values.put("rating", String.valueOf(rating));
        values.put("accountID", String.valueOf(accountID));
        values.put("gjp", Encoding.generateGJP(password));
        values.put("secret", Global.SECRET);

        Server.request("rateGJDemon21", values);

    }

    public static void rateGJStars21(long levelID, int rating, long accountID, String password){

        LinkedHashMap<String, String> values = new LinkedHashMap<>();
        values.put("levelID", String.valueOf(levelID));
        values.put("stars", String.valueOf(rating));
        values.put("accountID", String.valueOf(accountID));
        values.put("gjp", Encoding.generateGJP(password));
        values.put("secret", Global.SECRET);

        Server.request("rateGJStars21", values);

    }

    public static boolean reportGJLevel(long levelID){

        LinkedHashMap<String, String> values = new LinkedHashMap<>();
        values.put("levelID", String.valueOf(levelID));
        values.put("secret", Global.SECRET);

        return (Objects.requireNonNull(Server.request("reportGJLevel", values)).equalsIgnoreCase("1"));

    }

    public static boolean updateGJDesc20(long accountID, String password, long levelID, String description){

        LinkedHashMap<String, String> values = new LinkedHashMap<>();
        values.put("levelID", String.valueOf(levelID));
        values.put("accountID", String.valueOf(accountID));
        values.put("gjp", Encoding.generateGJP(password));
        values.put("levelDesc", Base64.getUrlEncoder().encodeToString(description.getBytes()));
        values.put("secret", Global.SECRET);

        return (Objects.requireNonNull(Server.request("updateGJDesc20", values)).equalsIgnoreCase("1"));

    }

    public static long uploadGJLevel21(LevelInfo levelInfo, long accountID, String password, String userName){

        LinkedHashMap<String, String> values = new LinkedHashMap<>(levelInfo.toValueMap());
        values.put("accountID", String.valueOf(accountID));
        values.put("gjp", Encoding.generateGJP(password));
        values.put("userName", userName);
        values.put("secret", Global.SECRET);

        return Long.parseLong(Objects.requireNonNull(Server.request("uploadGJLevel21", values)));

    }



}
