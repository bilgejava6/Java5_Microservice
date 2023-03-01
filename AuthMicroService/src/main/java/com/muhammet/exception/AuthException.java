package com.muhammet.exception;

import lombok.Getter;

@Getter
public class AuthException extends RuntimeException{
    private final EErrorType EErrorType;

    /**
     * Runtime dan miras aldığımız için hata mesajının kendisine iletilmesi gereklidir.
     * @param EErrorType
     */
    public AuthException(EErrorType EErrorType){
        super(EErrorType.getMessage());
        this.EErrorType = EErrorType;
    }

    public AuthException(EErrorType EErrorType, String message){
        super(message);
        this.EErrorType = EErrorType;
    }
}
