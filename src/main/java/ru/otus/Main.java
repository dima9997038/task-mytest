package ru.otus;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.otus.services.impl.PassTestServiceImpl;


@Configuration
@ComponentScan(basePackages = "ru.otus")
public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(Main.class);
        PassTestServiceImpl passTestService = ctx.getBean(PassTestServiceImpl.class);
        passTestService.startPassTest();
    }
}