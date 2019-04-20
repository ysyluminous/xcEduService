package com.xuecheng.manage_cms.dao;

import com.xuecheng.framework.domain.cms.CmsTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @Author YaoSiyuan
 * @Description //dao接口
 * @Date 9:35 2019/4/1
 * @Param
 * @return
 **/
public interface CmsTemplateRepository extends MongoRepository<CmsTemplate,String> {

}
