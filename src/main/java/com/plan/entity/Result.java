package com.plan.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by linzhihua on 2017/1/18.
 */
public class Result<T> implements Serializable {

    public static interface Status {

        /**
         * 业务处理成功
         */
        int SUCCESS = 200;

        /**
         * 服务端询问业务人员是否继续操作
         */
        int CONFIRM=202;
        // ========================
        /**
         * 权限异常
         */
        int AUTH = 403;

        /**
         * 业务条件不满足
         */
        int FAILED= 412;
        // ========================
        /**
         * 服务内部错误错误
         */
        int ERROR = 500;
    }

    private String message;
    private String exception;
    /**
     * 异常编号，每一个异常都需要赋值一个uuid作为唯一编号
     */
    private String exceptionId;
    private int code = 200;
    private T result;
    private List<String> keys;

    public List<String> getKeys() {
        return keys;
    }

    public void setKeys(List<String> keys) {
        this.keys = keys;
    }

    public Result() {
    }

    public Result(int status) {
        this.code = status;
    }

    public Result(T result) {
        this.result = result;
    }

    public Result(int status, T result) {
        this.code = status;
        this.result = result;
    }

    public Result(int status, String message) {
        this.message = message;
        this.code = status;
    }

    public Result(int status, String message, String exception) {
        this.message = message;
        this.code = status;
        this.exception = exception;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public String getExceptionId() {
        return exceptionId;
    }

    public void setExceptionId(String exceptionId) {
        this.exceptionId = exceptionId;
    }
}
