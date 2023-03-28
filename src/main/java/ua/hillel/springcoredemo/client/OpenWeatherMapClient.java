package ua.hillel.springcoredemo.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ua.hillel.springcoredemo.model.Weather;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

@Component
@RequiredArgsConstructor
@Setter
public class OpenWeatherMapClient  implements WeatherClient {
    private final HttpClient httpClient;
    private final ObjectMapper objectMapper;

    @Value("${weather.client.baseUrl:defaultValue}")
    private String baseUrl;

    @Value("${weather.client.apiToken}")
    private String apiToken;

    @Value("#{'${weather.client.list}'.split(\",\")}")
    private String[] list;

    @Override
    public Weather getCurrentWeather(String q) {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .GET()
                    .uri(new URI(baseUrl + "/weather?q=" + q + "&appid=" + apiToken))
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            String body = response.body();

            Weather weather = objectMapper.readValue(body, Weather.class);

            return weather;

        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
