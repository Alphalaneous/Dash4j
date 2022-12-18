package com.alphalaneous.Exceptions;

public class SaveFileNotLoadedException extends RuntimeException{

    public SaveFileNotLoadedException(String errorMessage){
        super(errorMessage);
    }

}
