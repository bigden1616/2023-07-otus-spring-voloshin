package ru.otus.hw8.converter;

import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.otus.hw8.domain.Author;

import java.util.List;

@Component
@RequiredArgsConstructor
public class AuthorsToStringConverter implements Converter<List<Author>, String> {

    private final Converter<Author, String> authorConverter;

    @Override
    public String convert(List<Author> authors) {
        StringBuilder sb = new StringBuilder();
        authors.forEach(t -> sb.append(authorConverter.convert(t)).append("\n"));
        return sb.toString();
    }
}
