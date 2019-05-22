package com.demo.config;

import com.alibaba.druid.pool.DruidDataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

/**
 * Created by majianghua on 2019/5/22.
 */
@Configuration
//@PropertySource("classpath:connect_pool.properties")
// 如果是application.properties，就不用写@PropertyScource("application.properties")，其他名字用些
public class DataSourceConfig {


    @Value("${spring.datasource.druid.driverClassName}")
    private String driverClassName;
    @Value("${spring.datasource.druid.url}")
    private String url;
    @Value("${spring.datasource.druid.username}")
    private String username;
    @Value("${spring.datasource.druid.password}")
    private String password;

    @Bean
    public DataSource logMethod() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

}