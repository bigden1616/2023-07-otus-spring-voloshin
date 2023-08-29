package ru.otus.hw3.mapper;

import ru.otus.hw3.domain.Test;

import java.io.File;

public interface TestMapper {

    Test map(File file);
}
