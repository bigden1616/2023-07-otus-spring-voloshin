package ru.otus.hw4.service;


public interface IOService {
    String inputWithText(String text);

    void outputString(String text);

    void outputEmptyLine();

    String[] inputWithSplit(String regex);
}
