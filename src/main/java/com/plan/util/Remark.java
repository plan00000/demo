package com.plan.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author: linzhihua
 * @Description: 实体Bean 属性、set、get方法中文注释
 * @Date: Created in 2019/8/22 8:57
 * @Modified By:
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
public @interface Remark {
    String value() ;
}
