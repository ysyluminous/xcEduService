package com.xuecheng.manage_cms_client.dao;

import com.xuecheng.framework.domain.cms.CmsPage;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @Author YaoSiyuan
 * @Description //dao接口
 * @Date 9:35 2019/4/1
 * @Param
 * @return
 **/
public interface CmsPageRepository extends MongoRepository<CmsPage,String> {


}
