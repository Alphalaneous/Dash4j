package com.alphalaneous.Servers;

import java.util.LinkedHashMap;

public class LevelPacks {

    public static String getGJGauntlets21(){
        return Server.request("getGJGauntlets21", null);
    }

    public static String getGJMapPacks21(int page){

        LinkedHashMap<String, String> values = new LinkedHashMap<>();
        values.put("page", String.valueOf(page));

        return Server.request("getGJMapPacks21", values);
    }


}
