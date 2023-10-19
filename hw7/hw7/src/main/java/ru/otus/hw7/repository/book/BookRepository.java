package ru.otus.hw7.repository.book;

import ru.otus.hw7.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long>{
}