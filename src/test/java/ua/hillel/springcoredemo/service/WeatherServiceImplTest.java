package ua.hillel.springcoredemo.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ua.hillel.springcoredemo.client.WeatherClient;
import ua.hillel.springcoredemo.util.TestUtil;
import ua.hillel.springcoredemo.model.Weather;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

public class WeatherServiceImplTest {
    private WeatherService weatherService;
    @Mock
    private WeatherClient weatherClientMock;
    private Weather testResponse;

    @BeforeEach
    public void init() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String content = TestUtil.readFromFile("weather-response.json");

        testResponse = objectMapper.readValue(content, Weather.class);

        MockitoAnnotations.openMocks(this);

        weatherService = new WeatherServiceImpl(weatherClientMock);

        when(weatherClientMock.getCurrentWeather(anyString())).thenReturn(testResponse);
    }

    @Test
    public void getWeatherByCityTest_success() {
        Weather weather = weatherService.getWeatherByCity("Kyiv");
        assertNotNull(weather);
    }
}
