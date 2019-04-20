package com.xuecheng.manage_cms.dao;

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
    /**
     * @Author YaoSiyuan
     * @Description // 根据页面名称查询
     * @Date 11:40 2019/4/1
     * @Param [pageName]
     * @return com.xuecheng.framework.domain.cms.CmsPage
     **/
    CmsPage findByPageName(String pageName);


    /**
     * @Author YaoSiyuan
     * @Description //根据页面名称，站点id，页面path查询
     * @Date 15:59 2019/4/3
     * @Param
     * @return
     **/
    CmsPage findByPageNameAndSiteIdAndPageWebPath(String pageName,String siteId,String pageWebPath);

}
