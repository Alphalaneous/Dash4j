package com.alphalaneous.Game;

public class MessageString {

    int rangeStart;
    int rangeEnd;
    int amount;
    MessageContents[] messageContents;

    MessageString(int rangeStart, int rangeEnd, int amount, MessageContents[] messageContents){
        this.rangeStart = rangeStart;
        this.rangeEnd = rangeEnd;
        this.amount = amount;
        this.messageContents = messageContents;
    }

    public MessageContents[] getMessageContents(){
        return messageContents;
    }

    public int getAmount() {
        return amount;
    }

    public int getRangeStart() {
        return rangeStart;
    }

    public int getRangeEnd() {
        return rangeEnd;
    }
}
