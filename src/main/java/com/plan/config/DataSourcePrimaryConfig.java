package com.plan.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @Author: linzhihua
 * @Description: 主数据源配置
 * @Date: Created in 2019/8/22 8:57
 * @Modified By:
 */
@Configuration
public class DataSourcePrimaryConfig {
    @Value("${mybatis.config-location}")
    private String mybatis_xml;

    @Value("${mybatis.mapper-locations}")
    private String mapper_locations;

    @Value("${spring.datasource.type}")
    private String dataSourceType;

    @Autowired
    private Environment env;

    @Bean(name="primaryDataSource")
    @ConfigurationProperties(prefix="spring.datasource.druid")
    public DataSource primaryDataSource(){
        AtomikosDataSourceBean ds = new AtomikosDataSourceBean();
        Properties prop = build(env, "spring.datasource.druid.");
        ds.setXaDataSourceClassName(dataSourceType);
        ds.setPoolSize(5);
        ds.setXaProperties(prop);
        return ds;
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

    @Bean
    public SqlSessionTemplate sqlSessionTemplateOne(@Qualifier("primarySqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactory);
        return template;
    }


    private Properties build(Environment env, String prefix) {
        Properties prop = new Properties();
        prop.put("name", env.getProperty(prefix + "primary.name"));
        prop.put("url", env.getProperty(prefix + "primary.jdbcUrl"));
        prop.put("username", env.getProperty(prefix + "primary.username"));
        prop.put("password", env.getProperty(prefix + "primary.password"));
        prop.put("driverClassName", env.getProperty(prefix + "primary.driverClassName", ""));
        prop.put("filters", env.getProperty(prefix + "filters"));
        prop.put("maxActive", env.getProperty(prefix + "maxActive", Integer.class));
        prop.put("initialSize", env.getProperty(prefix + "initialSize", Integer.class));
        prop.put("maxWait", env.getProperty(prefix + "maxWait", Integer.class));
        prop.put("minIdle", env.getProperty(prefix + "minIdle", Integer.class));
        prop.put("timeBetweenEvictionRunsMillis",
                env.getProperty(prefix + "timeBetweenEvictionRunsMillis", Integer.class));
        prop.put("minEvictableIdleTimeMillis", env.getProperty(prefix + "minEvictableIdleTimeMillis", Integer.class));
        prop.put("validationQuery", env.getProperty(prefix + "validationQuery"));
        prop.put("testWhileIdle", env.getProperty(prefix + "testWhileIdle", Boolean.class));
        prop.put("testOnBorrow", env.getProperty(prefix + "testOnBorrow", Boolean.class));
        prop.put("testOnReturn", env.getProperty(prefix + "testOnReturn", Boolean.class));
        prop.put("poolPreparedStatements", env.getProperty(prefix + "poolPreparedStatements", Boolean.class));
        prop.put("maxOpenPreparedStatements", env.getProperty(prefix + "maxOpenPreparedStatements", Integer.class));
        return prop;
    }

}
