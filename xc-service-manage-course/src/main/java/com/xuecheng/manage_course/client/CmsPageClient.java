package com.xuecheng.manage_course.client;

import com.xuecheng.framework.domain.cms.CmsPage;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(value = "XC-SERVICE-MANAGE-CMS")//指定远程调用的方法名
public interface CmsPageClient {


    //根据页面id查询页面信息，远程调用cms请求数据
    @GetMapping("/cms/page/get/{id}")//用getmapping标识远程调用的http的方法类型。
    public CmsPage findCmsPageById(@PathVariable("id") String id);
}
