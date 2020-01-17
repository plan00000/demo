package com.plan.exception;

import com.alibaba.fastjson.JSONObject;
import com.plan.entity.Result;
import com.plan.helper.ResultHelper;
import com.plan.util.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

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
        //错误日志记录
        if(CommonUtil.isNotEmpty(ex.getMessage())){
            log.error(ex.getMessage(),ex.getCause());
        }else{
            log.error(ex.toString(),ex.getCause());
        }
        /** 对异常信息进行数据库保存*/
        String exceptionId = null;


        Result result = new Result();
        if(ex instanceof ConditionException){//应用异常
            result = ResultHelper.faile(((ConditionException) ex).getResultErrMsg(),exceptionId);
        }else if(ex instanceof SystemException){//系统异常
            if(CommonUtil.isNotEmpty(ex.getCause())) {
                result = ResultHelper.error(((SystemException) ex).getMessage(), exceptionId, ex.getCause());
            }else{
                result = ResultHelper.error(((SystemException) ex).getResultErrMsg(),exceptionId);
            }
        }else if(ex instanceof BaseException){//基类异常
            result = ResultHelper.error(((BaseException) ex).getResultErrMsg(),exceptionId,ex);
        }else{
            if(CommonUtil.isEmpty(ex.getMessage())){
                //其他异常
                result = ResultHelper.error(ex.toString());
            }else{
                result = ResultHelper.error(ex.getLocalizedMessage(),exceptionId,ex);
            }
        }
        String responseJson = JSONObject.toJSONString(result);
        try {
            httpServletResponse.getOutputStream().write(responseJson.getBytes("utf-8"));
        } catch (IOException e) {
            log.error("与客户端通讯异常:" + e.getMessage(), e);
        }

        return mv;
    }
}
