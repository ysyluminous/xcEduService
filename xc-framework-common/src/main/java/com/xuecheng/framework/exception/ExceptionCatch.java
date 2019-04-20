package com.xuecheng.framework.exception;

import com.google.common.collect.ImmutableMap;
import com.xuecheng.framework.model.response.CommonCode;
import com.xuecheng.framework.model.response.ResponseResult;
import com.xuecheng.framework.model.response.ResultCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName ExceptionCatch
 * @Description 统一的异常捕获类
 * @Author yaosiyuan
 * @Date 2019/4/4 17:17
 * @Version 1.0
 **/
@ControllerAdvice
public class ExceptionCatch {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionCast.class);
    //    使用EXCEPTIONS存放异常类型和错误代码的映射，ImmutableMap的特点的一旦创建不可改变，并且线程安全


    //定义map，配置异常类型所对应的错误代码
    private static ImmutableMap<Class<? extends Throwable>,ResultCode> EXCEPTIONS;
    //定义map的builder对象，去构建ImmutableMap
    protected static ImmutableMap.Builder<Class<? extends Throwable>,ResultCode> builder = ImmutableMap.builder();

    //捕获CustomException此类异常
    @ExceptionHandler(CustomException.class)
    @ResponseBody
    public ResponseResult customException(CustomException customException) {
        //记录日志
        LOGGER.error("catch exception：{}", customException.getMessage());

        ResultCode resultCode = customException.getResultCode();
        return new ResponseResult(resultCode);
    }


    //捕获Exception此类异常
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseResult exception(Exception exception) {
        //记录日志
        LOGGER.error("catch exception：{}", exception.getMessage());
        if (EXCEPTIONS == null) {
            EXCEPTIONS =  builder.build();//EXCEPTIONS构建成功，并且不能更改。
        }

        // 从EXCEPTIONS中 找出异常类型所对应的错误代码，如果找到了，将错误代码相应给客户，如果找不到响应9999异常，
        ResultCode reslultCode = EXCEPTIONS.get(exception.getClass());

        if (reslultCode != null) {
            return new ResponseResult(reslultCode);
        } else {
            return new ResponseResult(CommonCode.SERVER_ERROR);
        }
    }


    static {
        //在这里加入一些基础的异常类型判断
        builder.put(HttpMessageNotReadableException.class, CommonCode.INVALID_PARAM);
    }

}
