package com.weather.taskweatherservice.model;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode
public class WeatherHistory {

    private Long id;
    private String weatherDate;
    private String weatherValue;

    public WeatherHistory() {}

    public WeatherHistory(String weatherValue) {
        this.weatherValue = weatherValue;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWeatherDate() {
        return weatherDate;
    }

    public void setWeatherDate(String weatherDate) {
        this.weatherDate = weatherDate;
    }

    public String getWeatherValue() {
        return weatherValue;
    }

    public void setWeatherValue(String weatherValue) {
        this.weatherValue = weatherValue;
    }
}
