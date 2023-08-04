package ru.otus.hw1.mapper;

import ru.otus.hw1.domain.Test;

import java.io.File;

public interface TestMapper {

    Test map(File file);
}
