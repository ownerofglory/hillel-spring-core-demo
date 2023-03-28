package ua.hillel.springcoredemo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class JdbcConfig {
    @Value("${jdbc.mysql.url}")
    private String mysqlUrl;
    @Value("${jdbc.mysql.username}")
    private String mysqlUsername;
    @Value("${jdbc.mysql.password}")
    private String mysqlPassword;
    @Value("${jdbc.mysql.driverClassName}")
    private String driverClassName;


    @Bean
    public JdbcTemplate mysqlJdbcTemplate() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(mysqlUrl);
        dataSource.setUsername(mysqlUsername);
        dataSource.setPassword(mysqlPassword);

        return new JdbcTemplate(dataSource);
    }
}
