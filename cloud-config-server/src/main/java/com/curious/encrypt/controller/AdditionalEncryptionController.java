package com.curious.encrypt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.curious.encrypt.PropertyEncryptor;

/**
 * Created by xudong on 2016/12/1.
 */
@RestController
public class AdditionalEncryptionController {

    @Autowired
    private PropertyEncryptor propertyEncryptor;

    @RequestMapping(value = "/encryptFile", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<byte[]> encryptFile(@RequestParam(value = "file") MultipartFile file,
                                              @RequestParam("key") String key,
                                              @RequestParam("keywords") String[] keywords) throws Exception {
        String fileName = file.getOriginalFilename();

        String encrypted = propertyEncryptor.encryptFile(file, key, keywords);

        byte[] bytes = encrypted.getBytes();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        httpHeaders.setContentLength(bytes.length);
        httpHeaders.setContentDispositionFormData("attachment", fileName);

        return new ResponseEntity<>(bytes, httpHeaders, HttpStatus.OK);
    }

    @RequestMapping(value = "/encryptMulti", method = RequestMethod.POST, produces = "application/json")
    public String encryptMultiProperties(@RequestBody String multiProperties,
                                         @RequestParam("key") String key) throws Exception {
        return propertyEncryptor.encryptMultiProperty(multiProperties, key);
    }
}
