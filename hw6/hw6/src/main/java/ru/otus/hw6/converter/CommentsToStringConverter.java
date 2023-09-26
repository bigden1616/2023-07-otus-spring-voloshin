package ru.otus.hw6.converter;

import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.otus.hw6.domain.Comment;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CommentsToStringConverter implements Converter<List<Comment>, String> {

    private final CommentToStringConverter commentToStringConverter;

    @Override
    public String convert(List<Comment> comments) {
        StringBuilder sb = new StringBuilder();
        comments.forEach(c -> sb.append(commentToStringConverter.convert(c)));
        return sb.toString();
    }
}
