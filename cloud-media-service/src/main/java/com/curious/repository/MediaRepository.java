package com.curious.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curious.entity.Media;

public interface MediaRepository extends JpaRepository<Media, Long> {

}
