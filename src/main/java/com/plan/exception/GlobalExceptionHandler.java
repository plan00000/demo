package com.plan.exception;

import com.plan.entity.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: linzhihua
 * @Description: 全局异常处理
 * @Date: Created in 2019/8/25 8:57
 * @Modified By:
 */
@Component
public class GlobalExceptionHandler implements HandlerExceptionResolver {

    private static Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception ex) {
        ModelAndView mv = new ModelAndView();
        httpServletResponse.setStatus(HttpStatus.OK.value()); //设置状态码
        httpServletResponse.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE); //设置ContentType
        httpServletResponse.setCharacterEncoding("UTF-8"); //避免乱码
        httpServletResponse.setHeader("Cache-Control", "no-cache, must-revalidate");

        if(ex instanceof java.lang.reflect.UndeclaredThrowableException){
            Throwable t=((java.lang.reflect.UndeclaredThrowableException) ex).getUndeclaredThrowable();
            if(t instanceof Exception){
                ex=(Exception)t;
            }
        }

        //对错误信息进行保存
        Result result = null;

        return null;
    }
}
