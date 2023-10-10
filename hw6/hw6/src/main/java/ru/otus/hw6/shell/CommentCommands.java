package ru.otus.hw6.shell;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.otus.hw6.converter.CommentToStringConverter;
import ru.otus.hw6.converter.CommentsToStringConverter;
import ru.otus.hw6.service.comment.CommentService;

@ShellComponent
@RequiredArgsConstructor
public class CommentCommands {

    private final CommentService commentService;

    private final CommentToStringConverter commentToStringConverter;

    private final CommentsToStringConverter commentsToStringConverter;

    @ShellMethod(value = "Get comment for book", key = {"get comment for book", "gcfb"})
    public String getCommentForBook(@ShellOption long bookId) {
        var comments = commentService.getCommentsForBook(bookId);
        return commentsToStringConverter.convert(comments);
    }

    @ShellMethod(value = "Get comment", key = {"get comment", "gc"})
    public String getComment(@ShellOption long commentId) {
        var comment = commentService.getById(commentId);
        return commentToStringConverter.convert(comment);
    }

    @ShellMethod(value = "Add comment", key = {"add comment", "ac"})
    public String addComment(@ShellOption long bookId, @ShellOption String text) {
        var comment = commentService.addComment(bookId, text);
        return commentToStringConverter.convert(comment);
    }
}
