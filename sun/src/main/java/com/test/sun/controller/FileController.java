package com.test.sun.controller;

import org.apache.commons.io.IOUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

/**
 * 文件上传下载
 */
@RestController
@RequestMapping("/file")
public class FileController {
    @PostMapping(value = "/upload",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void fileput(@RequestParam("photo") MultipartFile file){
        // 保存文件
        try {
            FileOutputStream fos = new FileOutputStream("/target/"+file.getOriginalFilename());
            IOUtils.copy(file.getInputStream(),fos);
            fos.close();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
    @GetMapping(value = "/download",produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] getfile() throws Exception {
        try {
            InputStream is = new FileInputStream("D:/timg.jpg");
            return IOUtils.toByteArray(is);
        } catch (FileNotFoundException e) {
            throw new Exception(e);
        } catch (IOException e) {
            throw new Exception(e);
        }
    }
}
