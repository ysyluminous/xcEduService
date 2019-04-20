package com.xuecheng.framework.exception;

import com.xuecheng.framework.model.response.ResultCode;

/**
 * @ClassName ExceptionCast
 * @Description 自定义异常代码类
 * @Author yaosiyuan
 * @Date 2019/4/4 17:14
 * @Version 1.0
 **/
public class ExceptionCast {


    /**
     * @Author YaoSiyuan
     * @Description //使用此静态方法抛出自定义异常
     * @Date 17:15 2019/4/4
     * @Param [resultCode]
     * @return void
     **/
    public static void cast(ResultCode resultCode){
        throw new   CustomException(resultCode);
    }
}
