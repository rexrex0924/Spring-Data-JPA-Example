package com.springdataJPAexample.jpa.repositories;

import com.springdataJPAexample.jpa.models.Video;
import org.springframework.data.jpa.repository.JpaRepository;


public interface VideoRepository extends JpaRepository<Video, Integer> {
}
