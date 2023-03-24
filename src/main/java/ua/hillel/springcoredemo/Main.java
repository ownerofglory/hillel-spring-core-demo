package ua.hillel.springcoredemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.hillel.springcoredemo.client.OpenWeatherMapClient;
import ua.hillel.springcoredemo.client.WeatherClient;
import ua.hillel.springcoredemo.model.Weather;
import ua.hillel.springcoredemo.model.WeatherDescription;
import ua.hillel.springcoredemo.service.WeatherService;
import ua.hillel.springcoredemo.service.WeatherServiceImpl;

public class Main {
    public static void main(String[] args) {
//        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        ApplicationContext context = new AnnotationConfigApplicationContext("ua.hillel.springcoredemo");

        WeatherService weatherService = (WeatherService) context.getBean(WeatherService.class);

        Weather weatherInKyiv = weatherService.getWeatherByCity("Kyiv");

        System.out.println();
    }
}