package com.bankingService.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static java.lang.System.in;

@Configuration
public class ApplicationBeanConfiguration {

    @Bean
    public BufferedReader reader() {
        return new BufferedReader(new InputStreamReader(in));
    }

}
