package ru.otus.hw3.utils;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.IOException;

public class FileUtils {

    public static File getFile(String path) throws IOException {
        Resource resource = new ClassPathResource(path);
        return resource.getFile();
    }
}
