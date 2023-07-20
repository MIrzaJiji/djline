package com.example.djline.controller;

import com.example.djline.model.FileEntity;
import com.example.djline.service.FileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.util.Base64;
import java.util.List;

@Controller
@Api(value = "File Management", description = "Operations related to file management")
@RequestMapping("upload")
public class FileUploadController {

    private final FileService fileService;

    public FileUploadController(FileService fileService) {
        this.fileService = fileService;
    }

    @PostMapping
    public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file) {
        fileService.uploadFile(file);
        return ResponseEntity.ok(HttpStatus.OK + "\nFile uploaded successfully");

    }

    @GetMapping("/files/{fileId}")
    public ResponseEntity<byte[]> getFileById(@PathVariable Long fileId) throws FileNotFoundException {
        FileEntity fileEntity = fileService.getFileById(fileId);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileEntity.getName() + "\"")
                .body(fileEntity.getData());
    }

    @GetMapping
    @ApiOperation(value = "Get all files", response = List.class)
    public List<FileData> getAllFiles() {
        return fileDataList;
    }


}