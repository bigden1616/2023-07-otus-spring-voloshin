package ru.otus.hw8.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.otus.hw8.domain.Book;

@Component
public class BookToStringConverter implements Converter<Book, String> {
    @Override
    public String convert(Book book) {
        StringBuilder sb = new StringBuilder();
        sb.append("Id: ").append(book.getId())
                .append("\tTitle: ").append(book.getTitle());

        sb.append("\tAuthor: {Id: ").append(book.getAuthor().getId())
                .append(", First Name: ").append(book.getAuthor().getFirstName())
                .append(", Last Name: ").append(book.getAuthor().getLastName())
                .append("}");


        sb.append("\tGenre: {Id: ").append(book.getGenre().getId())
                .append(", Name: ").append(book.getGenre().getName())
                .append("}");

        return sb.toString();
    }
}