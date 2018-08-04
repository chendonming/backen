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
        String newFileName = UUID.randomUUID().toString().replace("-", "");
        String fileName = file.getOriginalFilename();
        String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);

        try {
            FileUtil.uploadFile(file.getBytes(), filePath, newFileName);
            return new Result(BusinessStatus.SUCCESS, nginxPath + newFileName + "." + suffix);
        } catch (Exception e) {
            throw new BusinessException(BusinessStatus.FILEUPLOAD_ERROR);
        }
    }    
}