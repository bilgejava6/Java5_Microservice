package com.muhammet.exception;

import lombok.Getter;

@Getter
public class ElasticSearchException extends RuntimeException{
    private final EErrorType EErrorType;

    /**
     * Runtime dan miras aldığımız için hata mesajının kendisine iletilmesi gereklidir.
     * @param EErrorType
     */
    public ElasticSearchException(EErrorType EErrorType){
        super(EErrorType.getMessage());
        this.EErrorType = EErrorType;
    }

    public ElasticSearchException(EErrorType EErrorType, String message){
        super(message);
        this.EErrorType = EErrorType;
    }
}
