package com.alphalaneous.LevelObjects;

import com.alphalaneous.LevelObject;

public class TextObject extends LevelObject {

    private boolean encode = true;

    public TextObject(String text){
        this(text, true);
    }

    public TextObject(String text, boolean encode){
        this.encode = encode;
        setId(914);
        if(encode) setAndEncodeObjectText(text);
        else setObjectText(text);
    }

    public void setText(String text){
        if(encode) setAndEncodeObjectText(text);
        else setObjectText(text);
    }

}
