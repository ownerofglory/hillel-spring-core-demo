package ua.hillel.springcoredemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import java.net.http.HttpClient;

@Configuration
@PropertySource("classpath:application.properties")
public class WeatherClientConfig {
    @Bean
    @Scope("prototype")
    public HttpClient httpClient() {
        return HttpClient.newHttpClient();
    }
}
