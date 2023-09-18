package ru.otus.hw5.converter;

import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.otus.hw5.domain.Book;

import java.util.List;

@Component
@RequiredArgsConstructor
public class BooksToStringConverter implements Converter<List<Book>, String> {

    private final Converter<Book, String> bookConverter;

    @Override
    public String convert(List<Book> books) {
        StringBuilder sb = new StringBuilder();
        books.forEach(t -> sb.append(bookConverter.convert(t)).append("\n"));
        return sb.toString();
    }
}