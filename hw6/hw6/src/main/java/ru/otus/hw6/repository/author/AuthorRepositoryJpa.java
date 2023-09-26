package ru.otus.hw6.repository.author;

import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import ru.otus.hw6.domain.Author;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class AuthorRepositoryJpa implements AuthorRepository {

    @PersistenceContext
    private final EntityManager em;

    @Override
    public List<Author> getAll() {
        return em.createQuery("select a from Author a", Author.class).getResultList();
    }

    @Override
    public Author getById(long id) {
        return em.find(Author.class, id);
    }

    @Override
    public long insert(Author author) {
        return em.merge(author).getId();
    }
}