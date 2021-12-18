package com.weather.taskweatherservice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class DBConfig {

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource db = new DriverManagerDataSource();
        db.setDriverClassName("org.postgresql.Driver");
        db.setUrl("jdbc:postgresql://localhost:5432/weather_history");
        db.setUsername("test");
        db.setPassword("test");
        return db;
    }
}
