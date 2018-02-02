package com.program.tutorcommon.exception;

/**
 * @author Li on 2018/2/2.
 */
public class ServiceProcessException extends RuntimeException{

    public ServiceProcessException(String message){
        super(message);
    }

    public ServiceProcessException(String message,Throwable cause){
        super(message,cause);
    }
}
