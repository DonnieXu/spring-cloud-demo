package com.mode.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xudong on 2016/11/24.
 */
@RestController
public class SimpleController {

    @Value("${mysqldb.datasource.username}")
    private String info;

    @RequestMapping(value="/info",method= RequestMethod.GET)
    public String readUserInfo(){
        return info;
    }

    @Value("${mode.test.value}")
    private String value;

    @RequestMapping(value="/value",method= RequestMethod.GET)
    public String readUserValue(){
        return value;
    }

    @Value("${mysqldb.datasource.username}")
    private String duplicateValue;

    @RequestMapping(value="/duplicateValue",method= RequestMethod.GET)
    public String readDupicateValue() {
        return duplicateValue;
    }
}
