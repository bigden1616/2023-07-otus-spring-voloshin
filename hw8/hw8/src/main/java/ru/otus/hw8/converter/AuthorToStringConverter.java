package ru.otus.hw8.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.otus.hw8.domain.Author;

@Component
public class AuthorToStringConverter implements Converter<Author, String> {
    @Override
    public String convert(Author author) {
        StringBuilder sb = new StringBuilder();
        sb.append("Id: ").append(author.getId())
                .append("\tFirst name: ").append(author.getFirstName())
                .append("\tLast name: ").append(author.getLastName());
        return sb.toString();
    }
}
