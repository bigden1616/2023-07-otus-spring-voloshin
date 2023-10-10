package ru.otus.hw6.repository.comment;

import ru.otus.hw6.domain.Comment;

public interface CommentRepository {

    Comment getById(long id);

    long insert(Comment comment);
}
