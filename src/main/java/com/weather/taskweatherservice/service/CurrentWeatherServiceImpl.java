package com.weather.taskweatherservice.service;

import com.weather.taskweatherservice.model.WeatherHistory;
import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.ParserDelegator;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import com.weather.taskweatherservice.util.Parser;

@Service
public class CurrentWeatherServiceImpl implements CurrentWeatherService {
    @Override
    public String currentTemperature() throws IOException {
        WeatherHistory weatherHistory = new WeatherHistory();

        URLConnection response = new URL("https://yandex.ru/").openConnection();
        InputStreamReader inputStreamReader = new InputStreamReader(response.getInputStream());
        ParserDelegator parserDelegator = new ParserDelegator();
        parserDelegator.parse(inputStreamReader, new Parser(weatherHistory), true);
        inputStreamReader.close();

        return weatherHistory.getWeatherValue();
    }

}
