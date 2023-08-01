package com.example.djline.controller;

import com.example.djline.model.FileEntity;
import com.example.djline.service.FileService;
import io.swagger.annotations.Api;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@Api(value = "File Management", description = "Operations related to file management")
@RequestMapping("file")
public class FileUploadController {

    private final FileService fileService;

    public FileUploadController(FileService fileService) {
        this.fileService = fileService;
    }

    @PostMapping("/")
    public ResponseEntity<FileEntity> uploadTextFile(@RequestParam("file") MultipartFile file) throws IOException {
        FileEntity uploadedFile = fileService.uploadTextFile(file);
        return new ResponseEntity<>(uploadedFile, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<ResponseDTO>> getAllTextFiles() {
        List<FileEntity> fileEntities = fileService.getAllTextFiles();
        List<ResponseDTO> responseDTOs = fileEntities.stream().map(fileEntity -> new ResponseDTO(fileEntity.getId(), fileEntity.getName(), fileEntity.getData())).collect(Collectors.toList());


        for (ResponseDTO responseDTO : responseDTOs) {
            System.out.println("ID: " + responseDTO.getId());
            System.out.println("Name: " + responseDTO.getName());
            System.out.println("Data: " + responseDTO.getData());
            System.out.println("\n");
        }
        return new ResponseEntity<>(responseDTOs, HttpStatus.OK);
    }


    @GetMapping("/{fileId}")
    public ResponseEntity<String> getFileById(@PathVariable Long fileId) throws FileNotFoundException, FileNotFoundException {
        FileEntity fileEntity = fileService.getFileByID(fileId);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileEntity.getName() + "\"").body(fileEntity.getData());
    }

}