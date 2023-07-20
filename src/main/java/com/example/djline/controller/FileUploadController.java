package com.example.djline.controller;

import com.example.djline.service.FileService;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Api(value = "File Management", description = "Operations related to file management")
@RequestMapping("upload")
public class FileUploadController {

    private final FileService fileService;

    public FileUploadController(FileService fileService) {
        this.fileService = fileService;
    }

//    @PostMapping
//    public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file) {
//        fileService.uploadFile(file);
//        return ResponseEntity.ok(HttpStatus.OK + "\nFile uploaded successfully");
//
//    }


//    @GetMapping("/files/{fileId}")
//    public ResponseEntity<byte[]> getFileById(@PathVariable Long fileId) throws FileNotFoundException {
//        FileEntity fileEntity = fileService.getFileById(fileId);
//        return ResponseEntity.ok()
//                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileEntity.getName() + "\"")
//                .body(fileEntity.getData());
//    }

//    @GetMapping
//    @ApiOperation(value = "Get all files", response = List.class)
//    public List<FileData> getAllFiles() {
//        return fileDataList;
//    }


}