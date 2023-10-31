package ru.otus.hw8.service.comment;

import ru.otus.hw8.domain.Comment;

import java.util.List;

public interface CommentService {

    List<Comment> getCommentsForBook(String bookId);

    Comment getById(String id);

    Comment addComment(String bookId, String text);
}
