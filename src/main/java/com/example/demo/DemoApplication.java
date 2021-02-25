package com.example.demo;

import com.example.demo.web.controller.ConsoleController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class DemoApplication {

    public static void main(String[] args) throws TelegramApiException {
        //SpringApplication.run(DemoApplication.class, args);
        ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class);
        ConsoleController consoleController = context.getBean(ConsoleController.class);
        consoleController.run();
    }
}


