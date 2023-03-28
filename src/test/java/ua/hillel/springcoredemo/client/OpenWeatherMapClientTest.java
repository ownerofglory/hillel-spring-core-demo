package ua.hillel.springcoredemo.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ua.hillel.springcoredemo.client.OpenWeatherMapClient;
import ua.hillel.springcoredemo.client.WeatherClient;
import ua.hillel.springcoredemo.util.TestUtil;
import ua.hillel.springcoredemo.model.Weather;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class OpenWeatherMapClientTest {
    private WeatherClient client;

    @Mock
    private HttpClient httpClientMock;
    @Mock
    private HttpResponse<Object> responseMock;

    @BeforeEach
    public void setUp() throws IOException, InterruptedException {
        MockitoAnnotations.openMocks(this);
        ObjectMapper mapper = new ObjectMapper();

        client = new OpenWeatherMapClient(httpClientMock, mapper) {{
            // required setting due to URI validation
            setBaseUrl("http://default");
        }};
        String response = TestUtil.readFromFile("weather-response.json");
        when(responseMock.body()).thenReturn(response);
        when(httpClientMock.send(any(), any())).thenReturn(responseMock);
    }

    @Test
    public void getCurrentWeatherTest_success() {
        Weather weather = client.getCurrentWeather("Kyiv");
        assertNotNull(weather);
    }
}
