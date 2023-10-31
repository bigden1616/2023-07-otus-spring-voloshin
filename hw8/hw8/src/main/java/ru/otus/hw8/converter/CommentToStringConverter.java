package ru.otus.hw8.converter;

import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.otus.hw8.domain.Comment;

@Component
@RequiredArgsConstructor
public class CommentToStringConverter implements Converter<Comment, String> {
    @Override
    public String convert(Comment comment) {
        return "Id: " + comment.getId() +
                "\tText: " + comment.getText();
    }
}
