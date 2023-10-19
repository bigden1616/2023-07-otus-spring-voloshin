package ru.otus.hw7.converter;

import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.otus.hw7.domain.Genre;

import java.util.List;

@Component
@RequiredArgsConstructor
public class GenresToStringConverter implements Converter<List<Genre>, String> {

    private final Converter<Genre, String> genreConverter;

    @Override
    public String convert(List<Genre> genres) {
        StringBuilder sb = new StringBuilder();
        genres.forEach(t -> sb.append(genreConverter.convert(t)).append("\n"));
        return sb.toString();
    }
}