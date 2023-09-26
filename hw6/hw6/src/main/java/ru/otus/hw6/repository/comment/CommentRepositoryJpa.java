package ru.otus.hw6.repository.comment;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.otus.hw6.domain.Book;
import ru.otus.hw6.domain.Comment;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CommentRepositoryJpa implements CommentRepository {

    @PersistenceContext
    private final EntityManager em;

    @Override
    public List<Comment> getCommentsForBook(Book book) {
        var query =  em.createQuery("select c from Comment c where c.book=:book", Comment.class);
        query.setParameter("book", book);
        return query.getResultList();
    }

    @Override
    public Comment getById(long id) {
        return em.find(Comment.class, id);
    }

    @Override
    public long insert(Comment comment) {
        return em.merge(comment).getId();
    }
}
