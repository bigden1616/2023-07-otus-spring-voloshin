package ru.otus.hw8.repository.comment;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.otus.hw8.domain.Comment;

public interface CommentRepository extends MongoRepository<Comment, String> {
}