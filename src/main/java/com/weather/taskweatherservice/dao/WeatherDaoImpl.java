package com.weather.taskweatherservice.dao;

import com.weather.taskweatherservice.model.WeatherHistory;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class WeatherDaoImpl implements WeatherDao {

    private final JdbcTemplate jdbcTemplate;

    public WeatherDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public String getTemperature(String currentDate) {
        return jdbcTemplate.query(
                "SELECT * FROM weather_history WHERE weather_date::text = ?",
                new BeanPropertyRowMapper<>(WeatherHistory.class),
                currentDate
        ).stream()
                .findFirst()
                .orElseThrow()
                .getWeatherValue();
    }

    @Override
    public void addCurrentWeather(String temperature) {
        jdbcTemplate.update(
                "INSERT INTO weather_history(weather_value) VALUES (?)",
                temperature
        );
    }
}
