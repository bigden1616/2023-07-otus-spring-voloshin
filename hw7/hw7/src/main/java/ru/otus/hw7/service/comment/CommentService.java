package ru.otus.hw7.service.comment;

import ru.otus.hw7.domain.Comment;

import java.util.List;

public interface CommentService {

    List<Comment> getCommentsForBook(long bookId);

    Comment getById(long id);

    Comment addComment(long bookId, String text);
}
