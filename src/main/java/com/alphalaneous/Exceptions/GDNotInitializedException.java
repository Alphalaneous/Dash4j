package com.alphalaneous.Exceptions;

public class GDNotInitializedException extends RuntimeException{

    public GDNotInitializedException(String errorMessage){
        super(errorMessage);
    }

}
