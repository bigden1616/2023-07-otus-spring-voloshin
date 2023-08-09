package ru.otus.hw2.mapper;

import ru.otus.hw2.domain.Test;

import java.io.File;

public interface TestMapper {

    Test map(File file);
}
