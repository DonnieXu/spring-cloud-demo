package com.curious.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xudong on 2016/11/24.
 */
@RefreshScope
@RestController
public class SimpleController {

    @Value("${mode.test.value}")
    private String value;

    @RequestMapping(value="/value",method= RequestMethod.GET)
    public String readValue(){
        return value;
    }

    @Value("${mysqldb.datasource.username}")
    private String username;

    @RequestMapping(value="/username",method= RequestMethod.GET)
    public String readUsername() {
        return username;
    }

    @Value("${mysqldb.datasource.encryptedUsername}")
    private String encryptedUsername;

    @RequestMapping(value="/encryptedUsername",method= RequestMethod.GET)
    public String readEncryptUsername() {
        return encryptedUsername;
    }
}
