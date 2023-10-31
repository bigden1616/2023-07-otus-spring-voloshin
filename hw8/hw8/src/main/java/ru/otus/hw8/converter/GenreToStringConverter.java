package ru.otus.hw8.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.otus.hw8.domain.Genre;

@Component
public class GenreToStringConverter implements Converter<Genre, String> {
    @Override
    public String convert(Genre genre) {
        return "Id: " + genre.getId() +
                "\tName: " + genre.getName();
    }
}
