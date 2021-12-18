package com.weather.taskweatherservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class DBConfig {

    @Autowired
    private Environment env;

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource db = new DriverManagerDataSource();
        db.setDriverClassName(env.getProperty("driver"));
        db.setUrl(env.getProperty("url"));
        db.setUsername(env.getProperty("name"));
        db.setPassword(env.getProperty("password"));
        return db;
    }
}
