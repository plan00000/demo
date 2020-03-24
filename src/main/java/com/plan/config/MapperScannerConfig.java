package com.plan.config;

import com.plan.mybatis.MyBatisPrimaryDao;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: linzhihua
 * @Description: 数据源注解
 * @Date: Created in 2019/8/22 8:57
 * @Modified By:
 */
@Configuration
public class MapperScannerConfig {
    /**
     * 主数据源注解
     * @return
     */
    @Bean
    public MapperScannerConfigurer primaryMapperScannerConfigurer(){
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("com.plan");
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("primarySqlSessionFactory");
        mapperScannerConfigurer.setAnnotationClass(MyBatisPrimaryDao.class);
        return mapperScannerConfigurer;
    }

}
