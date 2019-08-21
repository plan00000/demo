package com.plan.config;

import com.plan.mybatis.MyBatisWjqDao;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 以注解的方式 进行多数据源配置
 */
@Configuration
public class MapperScannerConfig {
    @Bean
    public MapperScannerConfigurer primaryMapperScannerConfigurer(){
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("com.plan");
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("primarySqlSessionFactory");
        mapperScannerConfigurer.setAnnotationClass(MyBatisWjqDao.class);
        return mapperScannerConfigurer;
    }

}
