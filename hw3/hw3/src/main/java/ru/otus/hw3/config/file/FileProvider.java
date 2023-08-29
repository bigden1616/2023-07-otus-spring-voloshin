package ru.otus.hw3.config.file;

import java.io.File;
import java.io.IOException;

public interface FileProvider {

    File getFile(String path) throws IOException;
}
