package com.alphalaneous;

import static com.alphalaneous.SaveExplorer.escapeJson;

public class SaveValue {

    String type;
    Object value;

    public SaveValue(char c, Object value){

        switch (c){
            case 'r': type = "Double"; break;
            case 'i': type = "Integer"; break;
            case 's': type = "String"; break;
            case 't': type = "Boolean"; break;
            default: break;
        }

        this.value = value;
    }

    public String toString(){


        return "{" +
                "\"value\" : \"" + escapeJson(String.valueOf(value)) + "\"," +
                "\"type\" : \"" + escapeJson(type) +
                "\"}";
    }

}
