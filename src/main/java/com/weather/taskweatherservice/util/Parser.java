package com.weather.taskweatherservice.util;

import com.weather.taskweatherservice.model.WeatherHistory;

import javax.swing.text.MutableAttributeSet;
import javax.swing.text.html.HTML;
import javax.swing.text.html.HTMLEditorKit;

public class Parser extends HTMLEditorKit.ParserCallback {

    private WeatherHistory weatherHistory;
    private boolean tagDiv;

    public Parser(WeatherHistory weatherHistory) {
        this.weatherHistory = weatherHistory;
    }

    public void handleText(char[] date, int pos) {
        if (tagDiv) {
            weatherHistory.setWeatherValue(new String(date));
        }
    }

    public void handleStartTag(HTML.Tag tag, MutableAttributeSet a, int pos) {
        String classAttribute = (String) a.getAttribute(HTML.Attribute.CLASS);
        if (tag.equals(HTML.Tag.DIV)) {
            if (classAttribute != null && classAttribute.equals("weather__temp")) {
                tagDiv = true;
            }
        }
    }

    public void handleEndTag(HTML.Tag tag, int pos) {
        if (tag.equals(HTML.Tag.DIV)) {
            tagDiv = false;
        }
    }
}