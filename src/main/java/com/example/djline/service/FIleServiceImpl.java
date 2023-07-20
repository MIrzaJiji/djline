package com.example.djline.service;

import com.example.djline.model.FileEntity;
import com.example.djline.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Service
public class FIleServiceImpl implements FileService {

    @Autowired
    private FileRepository fileRepository;


    @Override
    public FileEntity uploadTextFile(MultipartFile file) throws IOException {
        String filename = file.getOriginalFilename();
        String data = new String(file.getBytes());

        FileEntity textFile = new FileEntity();

        textFile.setName(filename);
        textFile.setData(data);

        return fileRepository.save(textFile);
    }

    @Override
    public FileEntity getFileByID(Long fileId) throws FileNotFoundException {
        return fileRepository.findById(fileId)
                .orElseThrow(() -> new FileNotFoundException("File not found with ID: " + fileId));
    }

    @Override
    public List<FileEntity> getAllTextFiles() {
        return fileRepository.findAll();
    }
}
