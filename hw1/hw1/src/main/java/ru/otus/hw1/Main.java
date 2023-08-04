package ru.otus.hw1;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.hw1.service.UserService;

public class Main {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("/spring-context.xml");

        UserService userService = ctx.getBean(UserService.class);
        userService.initializeTest();
        userService.finishTest();
    }
}
