package com.curious.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.curious.entity.Media;
import com.curious.service.MediaService;

@RestController
@RequestMapping("")
@RefreshScope
public class MediaApi {

    @Autowired
    private MediaService mediaService;

    @RequestMapping(value = "/medias/{id}", method = RequestMethod.GET, produces = "application/json")
    public Media getMedia(@PathVariable("id") Long id) {
        return mediaService.findById(id);
    }

    @Value("${spring.datasource.url}")
    private String url;

    @RequestMapping(value = "/url", method = RequestMethod.GET, produces = "application/json")
    public String getUrl() {
        return url;
    }


}
