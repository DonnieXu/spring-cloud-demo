package com.curious;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.curious.service.MessageService;

/**
 * Created by xudong on 2016/11/30.
 */
@Configuration
@RefreshScope
@EnableAutoConfiguration
public class DataSourceConfig {

    @Value("${spring.datasource.url}")
    private String url;

    @Bean
    @RefreshScope
    @ConfigurationProperties(prefix="spring.datasource")
    public DataSource dataSource() {
        System.out.println(url);
        return DataSourceBuilder.create().build();
    }

    @Value("${message}")
    private String message;

    @Value("${encryptMessage}")
    private String encryptMessage;

    @Bean
    @RefreshScope
    public MessageService messageService() {
        System.out.println("creating message service");
        MessageService exampleService = new MessageService();
        exampleService.setMessage(message);
        exampleService.setEncryptMessage(encryptMessage);
        return exampleService;
    }
}
