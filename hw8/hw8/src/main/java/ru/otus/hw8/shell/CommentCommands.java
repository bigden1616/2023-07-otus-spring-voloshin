package ru.otus.hw8.shell;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.otus.hw8.converter.CommentToStringConverter;
import ru.otus.hw8.converter.CommentsToStringConverter;
import ru.otus.hw8.service.comment.CommentService;

@ShellComponent
@RequiredArgsConstructor
public class CommentCommands {

    private final CommentService commentService;

    private final CommentToStringConverter commentToStringConverter;

    private final CommentsToStringConverter commentsToStringConverter;

    @ShellMethod(value = "Get comment for book", key = {"get comment for book", "gcfb"})
    public String getCommentForBook(@ShellOption String bookId) {
        var comments = commentService.getCommentsForBook(bookId);
        return commentsToStringConverter.convert(comments);
    }

    @ShellMethod(value = "Get comment", key = {"get comment", "gc"})
    public String getComment(@ShellOption String commentId) {
        var comment = commentService.getById(commentId);
        return commentToStringConverter.convert(comment);
    }

    @ShellMethod(value = "Add comment", key = {"add comment", "ac"})
    public String addComment(@ShellOption String bookId, @ShellOption String text) {
        var comment = commentService.addComment(bookId, text);
        return commentToStringConverter.convert(comment);
    }
}
