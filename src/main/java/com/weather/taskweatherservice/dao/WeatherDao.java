package com.weather.taskweatherservice.dao;

import com.weather.taskweatherservice.model.WeatherHistory;

import java.util.List;

public interface WeatherDao {

    String getTemperature(String currentDate);

    void addCurrentWeather(String temperature);

}
