package com.xuecheng.api.filesystem;

import com.xuecheng.framework.domain.filesystem.response.UploadFileResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * @ClassName FileSystemControllerApi
 * @Description TODO
 * @Author yaosiyuan
 * @Date 2019/4/12 9:54
 * @Version 1.0
 **/

@Api(value = "文件管理接口",
        description = "文件管理接口，提供数据模型的管理、查询接口")
public interface FileSystemControllerApi {


    /**
     * @Author YaoSiyuan                         
     * @Description //文件上传接口
     * @Date 9:58 2019/4/12
     * @Param [multipartFile, filetag, businesskey, metadata]
     * @return com.xuecheng.framework.domain.filesystem.response.UploadFileResult       
     **/       
    @ApiParam("文件上传接口")
    public UploadFileResult upload(MultipartFile multipartFile,
                                   String filetag,
                                   String businesskey,
                                   String metadata);

}
