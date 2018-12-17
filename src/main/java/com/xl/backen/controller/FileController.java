package com.xl.backen.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import com.xl.backen.handler.BusinessException;
import com.xl.backen.handler.BusinessStatus;
import com.xl.backen.handler.Result;
import com.xl.backen.util.FileUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private static Logger log = LoggerFactory.getLogger(FileController.class);

    @Value("${filePath}")
    private String filePath;

    @Value("${nginxPath}")
    private String nginxPath;

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public Result<String> upload(@RequestParam("file") MultipartFile file) {
        log.info("文件上传: file: {}", file);
        String newFileName = UUID.randomUUID().toString().replace("-", "");
         String fileName = file.getOriginalFilename();
        String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);

        Calendar now = Calendar.getInstance();

        String filePathNow = filePath + now.get(Calendar.YEAR) + "/" + (now.get(Calendar.MONTH) + 1) + "/" + now.get(Calendar.DATE) + "/";

        String nginxPathNow = nginxPath + now.get(Calendar.YEAR) + "/" + (now.get(Calendar.MONTH) + 1) + "/" + now.get(Calendar.DATE) + "/";

        try {
            FileUtil.uploadFile(file.getBytes(), filePathNow, newFileName + "." + suffix);
            return new Result<String>(BusinessStatus.SUCCESS, nginxPathNow + newFileName + "." + suffix);
        } catch (Exception e) {
            throw new BusinessException(BusinessStatus.FILEUPLOAD_ERROR);
        }
    }
}