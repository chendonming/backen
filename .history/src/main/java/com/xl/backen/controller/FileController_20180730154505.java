package com.xl.backen.controller;

import java.util.UUID;

import com.xl.backen.handler.BusinessException;
import com.xl.backen.handler.BusinessStatus;
import com.xl.backen.handler.Result;
import com.xl.backen.util.FileUtil;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * FileController
 */
@RestController
@RequestMapping("/file")
public class FileController {
    @Value("${filePath}")
    private String filePath;

    @Value("${nginxPath}")
    private String nginxPath;

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public Result upload(@RequestParam("file") MultipartFile file) {
        String fileName = file.getOriginalFilename();

        String newFileName = UUID.randomUUID().toString().replace("-", "");

        System.out.println("上传的文件名:" + fileName);

        System.out.println("上传的路径: " + filePath);

        try {
            FileUtil.uploadFile(file.getBytes(), filePath, newFileName);
            return new Result(BusinessStatus.SUCCESS, "file:///" + filePath + newFileName);
        } catch (Exception e) {
            throw new BusinessException(BusinessStatus.FILEUPLOAD_ERROR);
        }
    }    
}