package ru.otus.hw7.repository.comment;

import ru.otus.hw7.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}