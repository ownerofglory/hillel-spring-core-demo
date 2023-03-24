package ua.hillel.springcoredemo.client;

import ua.hillel.springcoredemo.model.Weather;

public interface WeatherClient {
    Weather getCurrentWeather(String q);
}
