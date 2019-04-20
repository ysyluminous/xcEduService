package com.xuecheng.manage_cms.dao;

import com.xuecheng.manage_cms.service.PageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @ClassName RestTemplateTest
 * @Description TODO
 * @Author yaosiyuan
 * @Date 2019/4/5 20:07
 * @Version 1.0
 **/
@SpringBootTest
@RunWith(SpringRunner.class)
public class PageServiceTest {

    @Autowired
    PageService  pageService;


    @Test
    public void testGetHtml(){
        String pageHtml = pageService.getPageHtml("5ca81e308f83220d98086e68");
        System.out.println(pageHtml);
    }


}
