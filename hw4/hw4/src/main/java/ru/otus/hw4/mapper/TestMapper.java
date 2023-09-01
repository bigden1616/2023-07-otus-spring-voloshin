package ru.otus.hw4.mapper;

import ru.otus.hw4.domain.Test;

import java.io.File;

public interface TestMapper {

    Test map(File file);
}
