package com.xuecheng.test.freemarker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * @ClassName FreemarkerController
 * @Description TODO
 * @Author yaosiyuan
 * @Date 2019/4/4 21:27
 * @Version 1.0
 **/
@RequestMapping("/freemarker")
@Controller
public class FreemarkerController {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/banner")
    public String index_banner(Map<String, Object> map) {
        ResponseEntity<Map> forEntity = restTemplate.getForEntity("http://localhost:31001/cms/config/getmodel/5a791725dd573c3574ee333f", Map.class);
        Map body = forEntity.getBody();
        map.putAll(body);
        return "index_banner";
    }



    @RequestMapping("/test1")
    public String freemarker(Map<String, Object> map) {
//        map就是freemarker模板所使用的数据
        map.put("name", "test1");
        //返回模板文件名称,基于resources/templates路径的
        return "test1";
    }
}