package hw6.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.otus.hw5.domain.Author;

@Component
public class AuthorToStringConverter implements Converter<Author, String> {
    @Override
    public String convert(Author author) {
        StringBuilder sb = new StringBuilder();
        sb.append("Id: ").append(author.id())
                .append("\tFirst name: ").append(author.firstName())
                .append("\tLast name: ").append(author.lastName());
        return sb.toString();
    }
}
