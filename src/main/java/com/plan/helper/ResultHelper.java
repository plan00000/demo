package com.plan.helper;


import com.plan.entity.Result;
import com.plan.util.ThrowableUtil;

/**
 * 返回帮助类
 * Created by lzh on 2017/4/20 0020.
 */
public class ResultHelper {

    public static Result success(){
        Result result = new Result();
        result.setCode(Result.Status.SUCCESS);
        result.setMessage("操作成功");
        return result;
    }
    public static Result success(String message){
        Result result = new Result();
        result.setCode(Result.Status.SUCCESS);
        result.setMessage(message);
        return result;
    }
    public static Result success(String message, Object o){
        Result result = new Result();
        result.setCode(Result.Status.SUCCESS);
        result.setMessage(message);
        result.setResult(o);
        return result;
    }

    public static Result success(Object o){
        Result result = new Result();
        result.setCode(Result.Status.SUCCESS);
        result.setResult(o);
        return result;
    }

    public static Result faile(String message){
        Result result = new Result();
        result.setCode(Result.Status.FAILED);
        result.setMessage(message);
        return result;
    }
    public static Result faile(String message, String exceptionId){
        Result result = new Result();
        result.setCode(Result.Status.FAILED);
        result.setMessage(message);
        result.setExceptionId(exceptionId);
        return result;
    }
    public static Result error(String message){
        Result result = new Result();
        result.setCode(Result.Status.ERROR);
        result.setMessage(message);
        return result;
    }
    public static Result error(String message, String exceptionId, Throwable throwable){
        Result result = new Result();
        result.setCode(Result.Status.ERROR);
        result.setMessage(message);
        result.setExceptionId(exceptionId);
        result.setException(ThrowableUtil.getCause(throwable));
        return result;
    }


}
