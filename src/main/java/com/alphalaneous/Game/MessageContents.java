package com.alphalaneous.Game;

import com.alphalaneous.Encoding;
import com.alphalaneous.Utilities;

import java.util.Base64;
import java.util.LinkedHashMap;

public class MessageContents {

    LinkedHashMap<Integer, String> data = new LinkedHashMap<>();

    boolean encoded = false;

    MessageContents(){}

    MessageContents(LinkedHashMap<Integer, String> data){
        this.data = data;
    }

    public void setEncoded(boolean encoded){
        this.encoded = encoded;
    }

    public void setMessageID(long ID){
        data.put(1, String.valueOf(ID));
    }

    public void setAccountID(long ID){
        data.put(2, String.valueOf(ID));
    }

    public void setPlayerID(long ID){
        data.put(3, String.valueOf(ID));
    }

    public void setSubject(String subject){
        data.put(4, subject);
    }

    public void setBody(String body){
        data.put(5, body);
    }

    public void setUsername(String username){
        data.put(6, username);
    }

    public void setAge(String age){
        data.put(7, age);
    }

    public void setRead(boolean read){
        data.put(8, String.valueOf(read ? 1 : 0));
    }

    public void setSender(boolean sender){
        data.put(9, String.valueOf(sender ? 1 : 0));
    }

    public long getMessageID(){
        return Long.parseLong(data.get(1));
    }

    public long getAccountID(){
        return Long.parseLong(data.get(2));
    }

    public long getPlayerID(){
        return Long.parseLong(data.get(3));
    }

    public String getSubject(){
        if(encoded) return new String(Base64.getUrlDecoder().decode(data.get(4)));
        return data.get(4);
    }

    public String getBody(){
        if(encoded) return Encoding.xor(new String(Base64.getUrlDecoder().decode(data.get(4))), "14251");
        return data.get(6);
    }

    public String getUsername(){
        return data.get(6);
    }

    public String getAge(){
        return data.get(7);
    }

    public boolean isRead(){
        return data.get(8).equals("1");
    }

    public boolean isSender(){
        return data.get(9).equals("1");
    }

    public static MessageString parseMessagesString(String string, boolean encoded){

        int pipeAmount = Utilities.countOccurrences(string, '|');
        MessageContents[] messageContents = new MessageContents[pipeAmount+1];

        String[] partsHashtag = string.split("#");
        String[] pageValues = partsHashtag[1].split(":");
        int amount = Integer.parseInt(pageValues[0]);
        int rangeStart = Integer.parseInt(pageValues[1]);
        int rangeEnd = Integer.parseInt(pageValues[2]);

        String[] splitPipe = string.split("\\|");
        for(int i = 0; i < splitPipe.length; i++) {

            String[] splitColon = Utilities.splitEveryOther(splitPipe[i], ':');

            LinkedHashMap<Integer, String> values = new LinkedHashMap<>();

            for (String s : splitColon) {
                values.put(Integer.valueOf(s.split(":")[0]), s.split(":")[1]);
            }

            messageContents[i] = new MessageContents(values);
            messageContents[i].setEncoded(encoded);

        }


        return new MessageString(rangeStart, rangeEnd, amount, messageContents);
    }

}
