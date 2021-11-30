package org.example;

import org.example.config.Config;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigReactiveWebApplicationContext(Config.class);
        Communication communication = context.getBean("communication", Communication.class);

        System.out.println(communication.getAnswer());
    }
}
