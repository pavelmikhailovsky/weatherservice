package com.weather.taskweatherservice.service;

import java.io.IOException;
import java.net.MalformedURLException;

public interface CurrentWeatherService {

    String currentTemperature() throws IOException;
}
