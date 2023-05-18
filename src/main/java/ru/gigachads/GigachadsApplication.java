package ru.gigachads;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Описание класса
 */
@SpringBootApplication
@ComponentScan("ru.gigachads.mapper") // TODO: temporary solution to resolve the 'bean UserMapper could not be found' issue
public class GigachadsApplication {

    public static void main(String[] args) {
        SpringApplication.run(GigachadsApplication.class, args);
    }

}
