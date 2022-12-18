package com.alphalaneous.Servers;

import com.alphalaneous.Encoding;
import com.alphalaneous.Global;

import java.util.ArrayList;
import java.util.Base64;
import java.util.LinkedHashMap;
import java.util.Objects;

public class Comments {

    public static boolean deleteGJAccComment20(long accountID, String password, long commentID){
        LinkedHashMap<String, String> values = new LinkedHashMap<>();
        values.put("accountID", String.valueOf(accountID));
        values.put("gjp", Encoding.generateGJP(password));
        values.put("commentID", String.valueOf(commentID));
        values.put("secret", Global.SECRET);

        String success = Server.request("deleteGJAccComment20", values);
        return Objects.equals(success, "1");

    }

    public static boolean deleteGJComment20(long accountID, String password, long commentID, long levelID){
        LinkedHashMap<String, String> values = new LinkedHashMap<>();
        values.put("accountID", String.valueOf(accountID));
        values.put("gjp", Encoding.generateGJP(password));
        values.put("commentID", String.valueOf(commentID));
        values.put("levelID", String.valueOf(levelID));
        values.put("secret", Global.SECRET);

        String success =  Server.request("deleteGJComment20", values);
        return Objects.equals(success, "1");

    }

    public static String getGJAccountComments20(long accountID, int page){
        LinkedHashMap<String, String> values = new LinkedHashMap<>();
        values.put("accountID", String.valueOf(accountID));
        values.put("page", String.valueOf(page));
        values.put("secret", Global.SECRET);

        return Server.request("getGJAccountComments20", values);

    }

    public static String getGJCommentHistory(long userID, int page, int mode){
        LinkedHashMap<String, String> values = new LinkedHashMap<>();
        values.put("userID", String.valueOf(userID));
        values.put("page", String.valueOf(page));
        values.put("mode", String.valueOf(mode));
        values.put("secret", Global.SECRET);

        return Server.request("getGJCommentHistory", values);

    }

    public static String getGJComments21(long levelID, int page){
        LinkedHashMap<String, String> values = new LinkedHashMap<>();
        values.put("levelID", String.valueOf(levelID));
        values.put("page", String.valueOf(page));
        values.put("secret", Global.SECRET);

        return Server.request("getGJComments21", values);

    }

    public static boolean uploadGJAccComment20(long accountID, String password, String comment){
        LinkedHashMap<String, String> values = new LinkedHashMap<>();
        values.put("accountID", String.valueOf(accountID));
        values.put("gjp", Encoding.generateGJP(password));
        values.put("comment", Base64.getUrlEncoder().encodeToString(comment.getBytes()));
        values.put("secret", Global.SECRET);

        String success =  Server.request("uploadGJAccComment20", values);
        return !Objects.equals(success, "-1");

    }

    public static boolean uploadGJComment21(long accountID, String username, String password, String comment, long levelID, int percent){
        ArrayList<String> chkValues = new ArrayList<>();
        chkValues.add(username);
        chkValues.add(Base64.getUrlEncoder().encodeToString(comment.getBytes()));
        chkValues.add(String.valueOf(levelID));
        chkValues.add(String.valueOf(percent));

        String chk = Encoding.generateCHK(29481, chkValues, "0xPT6iUrtws0J");

        LinkedHashMap<String, String> values = new LinkedHashMap<>();
        values.put("accountID", String.valueOf(accountID));
        values.put("gjp", Encoding.generateGJP(password));
        values.put("userName", username);
        values.put("comment", Base64.getUrlEncoder().encodeToString(comment.getBytes()));
        values.put("levelID", String.valueOf(levelID));
        values.put("percent", String.valueOf(percent));
        values.put("chk", chk);
        values.put("secret", Global.SECRET);

        String success =  Server.request("uploadGJComment21", values);
        return !Objects.equals(success, "-1");

    }
}
