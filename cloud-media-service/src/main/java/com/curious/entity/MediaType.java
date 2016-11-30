package com.curious.entity;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum MediaType {
    IMAGE("IMAGE", "Image", "images"),
    VIDEO("VIDEO", "Video", "video");


    private static Map<String, MediaType> TYPES = new HashMap<>();

    public static MediaType getInstance(String type) {
        return TYPES.get(type);
    }

    private String type;
    private String friendlyType;
    private String ossStoreFolder;

    MediaType(String type, String friendlyType, String ossStoreFolder) {
        this.friendlyType = friendlyType;
        this.ossStoreFolder = ossStoreFolder;
        setType(type);
    }

    public String getType() {
        return type;
    }

    public String getFriendlyType() {
        return friendlyType;
    }

    public String getOssStoreFolder() {
        return ossStoreFolder;
    }

    private void setType(final String type) {
        this.type = type;
        if (TYPES == null) TYPES = new LinkedHashMap<>();
        if (!TYPES.containsKey(type)) {
            TYPES.put(type, this);
        } else {
            throw new RuntimeException("Cannot add the type: (" + type + "). It already exists as" +
                    " a type via " + getInstance(type).getClass().getName());
        }
    }

    /**
     * This method needs to be static so as for Jackson to construct ConfigKey instances from JSON.
     *
     * @param key
     * @return
     */
    @JsonCreator
    public static MediaType fromString(String key) {
        return key == null ? null : MediaType.valueOf(key.toUpperCase());
    }

}
