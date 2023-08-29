package ru.otus.hw3.config.file;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

@Component
public class FileProviderImpl implements FileProvider {

    @Override
    public File getFile(String path) throws IOException {
        var resource = new ClassPathResource(path);
        return resource.getFile();
    }
}
