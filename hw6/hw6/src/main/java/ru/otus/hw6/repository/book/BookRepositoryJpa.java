package ru.otus.hw6.repository.book;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.otus.hw6.domain.Book;

import java.util.List;

@Component
@RequiredArgsConstructor
public class BookRepositoryJpa implements BookRepository {

    @PersistenceContext
    private final EntityManager em;

    @Override
    public List<Book> getAll() {
        return em.createQuery("select b from Book b", Book.class).getResultList();
    }

    @Override
    public Book getById(long id) {
        return em.find(Book.class, id);
    }

    @Override
    public long insert(Book book) {
        return em.merge(book).getId();
    }

    @Override
    public void update(Book book) {
        em.refresh(book);
    }

    @Override
    public void delete(long id) {
        var book = getById(id);
        em.remove(book);
    }
}
