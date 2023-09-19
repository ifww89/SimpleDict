package ru.evgen.simpledict;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SimpleDictApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SimpleDictApplication.class, args);
        context.getBean(DatabaseUtils.class).fillDatabase();
    }
}
