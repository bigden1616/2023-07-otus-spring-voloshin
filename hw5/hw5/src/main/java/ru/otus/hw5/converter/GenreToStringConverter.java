package ru.otus.hw5.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.otus.hw5.domain.Genre;

@Component
public class GenreToStringConverter implements Converter<Genre, String> {
    @Override
    public String convert(Genre genre) {
        StringBuilder sb = new StringBuilder();
        sb.append("Id: ").append(genre.id())
                .append("\tName: ").append(genre.name());
        return sb.toString();
    }
}
