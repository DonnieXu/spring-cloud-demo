package com.curious.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * Created by xudong on 2016/11/30.
 */
@RefreshScope
@Component
public class MessageService {

    @Value("${message}")
    private String message;

    @Value("${encryptMessage}")
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