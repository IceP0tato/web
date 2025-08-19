package web.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import web.service.FileService;

@RestController
@RequestMapping("/file")
public class FileController {
    @Autowired
    private FileService fileService;

    @PostMapping("/upload")
    public String uploadFile(MultipartFile multipartFile) {
        System.out.println("multipartFile = " + multipartFile);
        System.out.println("FileController.uploadFile");
        return fileService.fileUpload(multipartFile);
    }

    @GetMapping("/download")
    public void fileDownload(@RequestParam String fileName, HttpServletResponse response) {
        fileService.fileDownload(fileName, response);
    }

    @GetMapping("/delete")
    public boolean fileDelete(@RequestParam String fileName) {
        return fileService.fileDelete(fileName);
    }
}
