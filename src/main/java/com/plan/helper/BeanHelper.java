package com.plan.helper;

import com.plan.exception.BaseException;
import com.plan.exception.SystemException;
import com.plan.util.CommonUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Author: linzhihua
 * @Description:
 * @Date: Created in 2020/1/19 17:21
 * @Modified By:
 */
public class BeanHelper {
    private static Logger logger = Logger.getLogger(BeanHelper.class);
    /**
     * 把bean转换成Map格式
     * 支持List递归转换,List转换成转换成Key:list[i].propertyName格式
     * 支持FormatConvert转换格式注解
     * @param map
     * @param bean
     * @return
     */
    public static Map<String, String> beanToMap(Map<String, String> map, Object bean){
        Object value=null;
        String key=null;
        //判断Map和Bean是否为null
        if(map==null){
            throw new SystemException("Bean转换成Map失败","map不能为null","请检查程序");
        }
        if(bean==null){
            throw new SystemException("Bean转换成Map失败","bean不能为null","请检查程序");
        }
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(bean.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();

            for (PropertyDescriptor property : propertyDescriptors) {
                String propertyName = property.getName();
                key=propertyName;
                if (key.compareToIgnoreCase("class") == 0) {
                    continue;
                }
                Method getter = property.getReadMethod();
                Class returnType =getter.getReturnType();

                if(CommonUtil.isPrimitiveOrPrimitiveWrapper(returnType)||Date.class.isAssignableFrom(returnType)){
//                    map.put(key,formatPropertyValue(bean,propertyName));
                }else if(returnType.isAssignableFrom(List.class)){
                    List list= (List) getter.invoke(bean);
                    if(CommonUtil.isNotEmpty(list)){
                        for(int i=0;i<list.size();i++ ) {
                            Object listValue = list.get(i);
                            if (listValue == null ) {
                                map.put(key + "[" + i + "]", "");
                            }else if (listValue != null && CommonUtil.isPrimitiveOrPrimitiveWrapper(listValue.getClass())) {
                                map.put(key + "[" + i + "]", listValue.toString());
                            } else  if(CommonUtil.equalsString(listValue.getClass().getName(),"cn.com.pansky.ach.core.base.AchFileAttached")){
                                //如果列表中是附件对象，直接退出循环，不转换
                                break;
                            } else {
                                Map<String, String> listBeanMap = beanToMap(map.getClass().newInstance(), list.get(i));
                                Set<String> listBeanMapKeys = listBeanMap.keySet();
                                for (String listBeanMapKey : listBeanMapKeys) {
                                    Object listBeanMapValue = listBeanMap.get(listBeanMapKey);
                                    if (listBeanMapValue != null) {
                                        map.put(key + "[" + i + "]." + listBeanMapKey, listBeanMapValue.toString());
                                    } else {
                                        map.put(key + "[" + i + "]." + listBeanMapKey, "");
                                    }
                                }
                            }
                        }
                    }
                }else{
                    value=getter.invoke(bean);
                    if(value!=null){
                        Map<String, String> listBeanMap = beanToMap(map.getClass().newInstance(), value);
                        Set<String> listBeanMapKeys = listBeanMap.keySet();
                        for (String listBeanMapKey : listBeanMapKeys) {
                            Object listBeanMapValue = listBeanMap.get(listBeanMapKey);
                            if (listBeanMapValue != null) {
                                map.put(key +"." + listBeanMapKey, listBeanMapValue.toString());
                            } else {
                                map.put(key + "." + listBeanMapKey, "");
                            }
                        }
                    }

                }
            }
            return map;
        } catch (Exception e) {
            if(e instanceof BaseException) {
                throw (BaseException)e;
            }else{
                throw new SystemException("Map转换成Bean异常", e,"请联系管理员");
            }
        }
    }
}
