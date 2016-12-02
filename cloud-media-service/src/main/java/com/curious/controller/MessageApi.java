package com.curious.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.curious.service.MessageService;

/**
 * Created by xudong on 2016/11/30.
 */
@RestController
@RequestMapping("")
@RefreshScope
public class MessageApi {
    @Autowired
    private MessageService exampleService;

    @RequestMapping(value = "/message", method = RequestMethod.GET, produces = "application/json")
    public String message() {
        return exampleService.getMessage();
    }

    @RequestMapping(value = "/encryptMessage", method = RequestMethod.GET, produces = "application/json")
    public String encryptMessage() {
        return exampleService.getEncryptMessage();
    }
}
