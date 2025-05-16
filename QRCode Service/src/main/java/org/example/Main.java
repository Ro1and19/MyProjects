package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.BufferedImageHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;

import java.awt.image.BufferedImage;

@SpringBootApplication
public class Main {

    @Bean
    public HttpMessageConverter<BufferedImage> bufferedImageHttpMessageConverter() {
        return new BufferedImageHttpMessageConverter();
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

}