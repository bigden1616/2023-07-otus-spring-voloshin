package ru.otus.hw2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.otus.hw2.service.TestRunner;

@ComponentScan
@Configuration
public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(Main.class);
        ctx.refresh();

        TestRunner testRunner = ctx.getBean(TestRunner.class);
        testRunner.runTest();
    }
}
