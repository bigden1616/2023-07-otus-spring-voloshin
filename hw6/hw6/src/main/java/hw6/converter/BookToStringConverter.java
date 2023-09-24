package hw6.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.otus.hw5.domain.Book;

@Component
public class BookToStringConverter implements Converter<Book, String> {
    @Override
    public String convert(Book book) {
        StringBuilder sb = new StringBuilder();
        sb.append("Id: ").append(book.id())
                .append("\tTitle: ").append(book.title());

        sb.append("\tAuthor: {Id: ").append(book.author().id())
                .append(", First Name: ").append(book.author().firstName())
                .append(", Last Name: ").append(book.author().lastName())
                .append("}");


        sb.append("\tGenre: {Id: ").append(book.genre().id())
                .append(", Name: ").append(book.genre().name())
                .append("}");

        return sb.toString();
    }
}