package com.example.mod1.task4;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class MyConfig1 {

    @Bean
    public Pet3 cat3Bean(){
        return new Cat3();
    }

    @Bean
    public Person3 person3Bean() {
        return new Person3(cat3Bean());
    }
}
