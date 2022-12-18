package com.alphalaneous.Servers;

import com.alphalaneous.Encoding;
import com.alphalaneous.Global;

import java.util.Base64;
import java.util.LinkedHashMap;

public class Messages {

    public static void deleteGJMessages20(long accountID, String password, long messageID, boolean isSender){
        LinkedHashMap<String, String> values = new LinkedHashMap<>();
        values.put("accountID", String.valueOf(accountID));
        values.put("gjp", Encoding.generateGJP(password));
        values.put("messageID", String.valueOf(messageID));
        values.put("secret", Global.SECRET);
        if(isSender) values.put("isSender", "1");

        Server.request("deleteGJMessages20", values);
    }

    public static String downloadGJMessage20(long accountID, String password, long messageID){
        LinkedHashMap<String, String> values = new LinkedHashMap<>();
        values.put("accountID", String.valueOf(accountID));
        values.put("gjp", Encoding.generateGJP(password));
        values.put("messageID", String.valueOf(messageID));
        values.put("secret", Global.SECRET);

        return Server.request("downloadGJMessage20", values);
    }

    public static String getGJMessages20(long accountID, String password, int page, boolean getSent){
        LinkedHashMap<String, String> values = new LinkedHashMap<>();
        values.put("accountID", String.valueOf(accountID));
        values.put("gjp", Encoding.generateGJP(password));
        values.put("page", String.valueOf(page));
        if(getSent) values.put("getSent", "1");
        values.put("secret", Global.SECRET);

        return Server.request("getGJMessages20", values);
    }

    public static String uploadGJMessage20(long accountID, String password, long toAccountID, String subject, String body){
        LinkedHashMap<String, String> values = new LinkedHashMap<>();
        values.put("accountID", String.valueOf(accountID));
        values.put("gjp", Encoding.generateGJP(password));
        values.put("toAccountID", String.valueOf(toAccountID));
        values.put("subject", Base64.getUrlEncoder().encodeToString(subject.getBytes()));
        values.put("body", Base64.getUrlEncoder().encodeToString(body.getBytes()));
        values.put("secret", Global.SECRET);

        return Server.request("uploadGJMessage20", values);
    }



}
