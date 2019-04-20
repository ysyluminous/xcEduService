package com.xuecheng.filesystem.controller;

import com.xuecheng.api.filesystem.FileSystemControllerApi;
import com.xuecheng.filesystem.service.FileSystemService;
import com.xuecheng.framework.domain.filesystem.response.UploadFileResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @ClassName FileSystemController
 * @Description TODO
 * @Author yaosiyuan
 * @Date 2019/4/12 11:48
 * @Version 1.0
 **/
@RestController
@RequestMapping("/filesystem")
public class FileSystemController  implements FileSystemControllerApi {
    @Autowired
    FileSystemService fileSystemService;
    @Override
    @PostMapping("/upload")
    public UploadFileResult upload(@RequestParam("file") MultipartFile file,
                                   @RequestParam(value = "filetag", required = true) String
                                           filetag,
                                   @RequestParam(value = "businesskey", required = false) String
                                           businesskey,
                                   @RequestParam(value = "metedata", required = false) String
                                           metadata) {
        return fileSystemService.upload(file,filetag,businesskey,metadata);
    }

}
