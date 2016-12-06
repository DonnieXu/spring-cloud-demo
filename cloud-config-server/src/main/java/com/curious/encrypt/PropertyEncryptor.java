package com.curious.encrypt;

import java.util.HashMap;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.config.server.encryption.TextEncryptorLocator;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by xudong on 2016/12/1.
 */
@Component
public class PropertyEncryptor {

    @Autowired
    private TextEncryptorLocator locator;

    private static final String separator = System.getProperty("line.separator");

    public String encryptFile(MultipartFile config, String alias, String[] keywords) throws Exception {
        Scanner scanner = new Scanner(config.getInputStream());

        boolean checkKeyword = false;
        if (keywords != null && keywords.length > 0) {
            checkKeyword = true;
        }
        return encryptWithScanner(scanner, alias, checkKeyword, keywords);
    }

    public String encryptMultiProperty(String multiProperties, String alias) throws Exception {
        Scanner scanner = new Scanner(multiProperties);
        return encryptWithScanner(scanner, alias, false, null);
    }

    private String encryptWithScanner(Scanner scanner, String alias, boolean checkKeyword, String[] keywords) throws Exception {
        HashMap<String, String> keys = new HashMap<>();
        keys.put("key", alias);
        TextEncryptor encryptor = locator.locate(keys);
        if (encryptor == null) {
            throw new Exception("no encryptor found");
        }
        String prefix = "{cipher}{key:" + alias + "}";

        StringBuilder builder = new StringBuilder();
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] strs = line.split("=", 2);
            if (!isPropertyLine(line) || isEncrypted(line)
                    || (checkKeyword && !containsKey(strs[0], keywords))) {
                builder.append(line).append(separator);
            } else {
                builder.append(strs[0].trim()).append("=");
                String encrypted = encryptor.encrypt(strs[1].trim());
                builder.append(prefix).append(encrypted).append(separator);
            }
        }
        return builder.toString();
    }

    private boolean isPropertyLine(String line) {
        String trimStr = line.trim();
        if (trimStr.equals("") || trimStr.startsWith("#")) {
            return false;
        }
        return true;
    }

    private boolean isEncrypted(String line) {
        return line.contains("{cipher}");
    }

    private boolean containsKey(String str, String[] keywords) {
        if (keywords == null) {
            return false;
        }

        for (String keyword : keywords) {
            if (str.toLowerCase().contains(keyword.toLowerCase())) {
                return true;
            }
        }
        return false;
    }



}
