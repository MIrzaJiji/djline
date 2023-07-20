package com.example.djline.service;

import com.example.djline.model.FileEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface FileService {

    FileEntity uploadTextFile(MultipartFile file) throws IOException;

    FileEntity getFileByID(Long fileId) throws FileNotFoundException;

    List<FileEntity> getAllTextFiles();

}
