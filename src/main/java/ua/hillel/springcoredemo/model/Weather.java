package ua.hillel.springcoredemo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Weather {
    private MainWeather main;
    @JsonProperty("weather")
    private List<WeatherDescription> description;
}
