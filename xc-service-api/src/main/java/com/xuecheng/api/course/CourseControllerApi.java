package com.xuecheng.api.course;

import com.xuecheng.framework.domain.course.CoursePic;
import com.xuecheng.framework.domain.course.Teachplan;
import com.xuecheng.framework.domain.course.ext.CourseView;
import com.xuecheng.framework.domain.course.ext.TeachplanNode;
import com.xuecheng.framework.model.response.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @ClassName CourseControllerApi
 * @Description TODO
 * @Author yaosiyuan
 * @Date 2019/4/8 17:43
 * @Version 1.0
 **/
@Api(value = "课程管理接口",
        description = "课程管理接口，提供课程的管理、增删改查")
public interface CourseControllerApi {
    @ApiOperation("课程计划查询")
    public TeachplanNode findTeachplanList(String courseId);

    @ApiOperation("添加课程计划")
    public ResponseResult addTeachplan(Teachplan teachplan);

    @ApiOperation("添加课程图片")
    public ResponseResult addCoursePic(String courseId,String pic);


    @ApiOperation("获取课程图片")
    public CoursePic findCoursePic(String pic);

    @ApiOperation("获取课程基础信息")
    public ResponseResult deleteCoursePic(String pic);

    @ApiOperation("课程视图查询")
    public CourseView courseview(String id);


}
