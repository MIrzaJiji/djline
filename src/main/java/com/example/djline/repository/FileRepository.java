package com.example.djline.repository;

import com.example.djline.model.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepository extends JpaRepository<FileEntity, Long> {
//    Optional<FileEntity> findById(Long fileId);

//    List<FileEntity> findAll();
}

