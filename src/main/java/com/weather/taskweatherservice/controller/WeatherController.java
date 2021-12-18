package com.weather.taskweatherservice.controller;

import com.weather.taskweatherservice.service.WeatherService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Map;

@RestController
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @RequestMapping(value = "/weather", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Map<String, String> getWeather() throws IOException {
        return Map.of("temperature", weatherService.getCurrentWeather());
    }
}
