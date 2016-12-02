package com.curious.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curious.entity.Media;
import com.curious.repository.MediaRepository;

@Service
public class MediaServiceImpl implements MediaService {

    @Autowired
    private MediaRepository mediaRepository;

    @Override
    public Media findById(Long id) {
        return mediaRepository.findOne(id);
    }
}
