package ru.otus.hw6.repository.comment;

import ru.otus.hw6.domain.Book;
import ru.otus.hw6.domain.Comment;

import java.util.List;

public interface CommentRepository {

    List<Comment> getCommentsForBook(Book book);

    Comment getById(long id);

    long insert(Comment comment);
}
