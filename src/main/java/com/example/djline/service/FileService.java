package com.example.djline.service;

import com.example.djline.model.FileEntity;
import com.example.djline.repository.FileRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Service
public class FileService {

    private final FileRepository fileRepository;

    public FileService(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }


    public FileEntity getFileById(Long fileId) throws FileNotFoundException {
        return fileRepository.findById(fileId)
                .orElseThrow(() -> new FileNotFoundException("File not found with ID: " + fileId));
    }

//    public List<FileEntity> getAllFile() throws NoSuchElementException {
//        List<FileEntity> files = fileRepository.findAll();
//        if (files.isEmpty()) {
//            throw new NoSuchElementException("No files found");
//        }
//        return files;
//    }


    public List<FileEntity> getAllEntities() {
        return fileRepository.findAll();
    }

    public void uploadFile(MultipartFile file) {
        try {
            String fileName = file.getOriginalFilename();
            byte[] data = file.getBytes();

            FileEntity fileEntity = new FileEntity();
            fileEntity.setName(fileName);
            fileEntity.setData(data);

            fileRepository.save(fileEntity);
        } catch (IOException e) {
            // Handle exception appropriately
        }
    }
}
