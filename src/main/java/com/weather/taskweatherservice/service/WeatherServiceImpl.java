package com.weather.taskweatherservice.service;

import com.weather.taskweatherservice.dao.WeatherDao;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.NoSuchElementException;

@Service
public class WeatherServiceImpl implements WeatherService {

    private final WeatherDao weatherDao;
    private final CurrentWeatherService currentWeatherService;

    public WeatherServiceImpl(WeatherDao weatherDao, CurrentWeatherService currentWeatherService) {
        this.weatherDao = weatherDao;
        this.currentWeatherService = currentWeatherService;
    }

    @Override
    public String getCurrentWeather() throws IOException {
        String temperature;
        SimpleDateFormat formatForCurrentDate = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = formatForCurrentDate.format(new Date());

        try {
            temperature = weatherDao.getTemperature(currentDate);
        } catch (NoSuchElementException e) {
            temperature = currentWeatherService.currentTemperature();
            weatherDao.addCurrentWeather(temperature);
        }

        return temperature;
    }
}
