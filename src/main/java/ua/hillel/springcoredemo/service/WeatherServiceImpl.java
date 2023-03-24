package ua.hillel.springcoredemo.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.hillel.springcoredemo.client.WeatherClient;
import ua.hillel.springcoredemo.model.Weather;

@Component
@AllArgsConstructor
public class WeatherServiceImpl implements WeatherService {
    private WeatherClient client;


    @Override
    public Weather getWeatherByCity(String city) {
        return client.getCurrentWeather(city);
    }
}
