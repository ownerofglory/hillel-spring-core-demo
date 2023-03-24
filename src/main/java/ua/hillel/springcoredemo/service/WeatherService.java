package ua.hillel.springcoredemo.service;

import ua.hillel.springcoredemo.model.Weather;

public interface WeatherService {
    Weather getWeatherByCity(String city);
}
