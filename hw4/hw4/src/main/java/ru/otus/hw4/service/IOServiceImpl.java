package ru.otus.hw4.service;

import org.springframework.stereotype.Service;

import java.io.PrintStream;
import java.util.Scanner;

@Service
public class IOServiceImpl implements IOService {

    private final Scanner scanner;

    private final PrintStream printStream;

    public IOServiceImpl() {
        this.scanner = new Scanner(System.in);
        this.printStream = System.out;
    }

    @Override
    public String inputWithText(String text) {
        printStream.print(text);
        return scanner.next();
    }

    @Override
    public void outputString(String text) {
        printStream.println(text);
    }

    @Override
    public void outputEmptyLine() {
        printStream.println();
    }

    @Override
    public String[] inputWithSplit(String regex) {
        return scanner.next().split(regex);
    }
}
