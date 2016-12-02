package com.curious.service;

/**
 * Created by xudong on 2016/11/30.
 */

public class MessageService {

    private String message;
    private String encryptMessage;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getEncryptMessage() {
        return encryptMessage;
    }

    public void setEncryptMessage(String encryptMessage) {
        this.encryptMessage = encryptMessage;
    }
}