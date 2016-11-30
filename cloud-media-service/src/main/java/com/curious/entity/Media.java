package com.curious.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "md_media")
public class Media implements Serializable {
    // ------------------------
    // PRIVATE FIELDS
    // ------------------------

    // An auto-generated id (unique for each user in the db)
    @Id
    @Column(columnDefinition = "bigint(13)")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // Image or Video
    @Column(length = 10)
    @Enumerated(EnumType.STRING)
    private MediaType type;

    /**
     * The unique filename of this media.
     */
    @Column(length = 50)
    private String fileName;

    @Column(length = 255)
    private String url;

    @Column(columnDefinition = "int(6)")
    private Integer width;

    @Column(columnDefinition = "int(6)")
    private Integer height;

    @CreatedDate
    @Column(columnDefinition = "bigint(13)")
    private Long createdAt;

    @LastModifiedDate
    @Column(columnDefinition = "bigint(13)")
    private Long updatedAt;

    @Lob
    @Type(type = "org.hibernate.type.StringClobType")
    @Column(columnDefinition = "TEXT")
    private String thumbnail;

    // ------------------------
    // PUBLIC METHODS
    // ------------------------

    // Constructor methods

    // Getter and setter methods

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MediaType getType() {
        return type;
    }

    public void setType(MediaType type) {
        this.type = type;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public Long getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Long updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    //-----------------------
    // public methods
    //-----------------------
    public Media type(MediaType type) {
        setType(type);
        return this;
    }

    public Media fileName(String fileName) {
        setFileName(fileName);
        return this;
    }

    public Media url(String url) {
        setUrl(url);
        return this;
    }

    public Media width(Integer width) {
        setWidth(width);
        return this;
    }

    public Media height(Integer height) {
        setHeight(height);
        return this;
    }

    public Media thumbnail(String thumbnail) {
        setThumbnail(thumbnail);
        return this;
    }
}
