package com.plan.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * 主数据配置
 */
@Configuration
public class DataSourcePrimaryConfig {
    @Value("${mybatis.config-location}")
    private String mybatis_xml;

    @Value("${mybatis.mapper-locations}")
    private String mapper_locations;

    @Bean(name="primaryDataSource")
    @ConfigurationProperties(prefix="spring.datasource.primary")
    public DataSource primaryDataSource(){
        return DataSourceBuilder.create().build();
    }
    @Bean(name="primarySqlSessionFactory")
    public SqlSessionFactory primarySqlSessionFactory(@Qualifier("primaryDataSource")DataSource dataSource) throws Exception{
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        Resource[] configLocations = new PathMatchingResourcePatternResolver().getResources(mybatis_xml);
        if (configLocations == null || configLocations.length != 1) {
            throw new RuntimeException("cannot be resolved to URL because it does not exist");
        }
        bean.setConfigLocation(configLocations[0]);
        Resource[] mapperLocations = new PathMatchingResourcePatternResolver().getResources(mapper_locations);
        if (mapperLocations == null || mapperLocations.length != 1) {
            throw new RuntimeException("cannot be resolved to URL because it does not exist");
        }
        bean.setMapperLocations(mapperLocations);

        return bean.getObject();
    }
}
