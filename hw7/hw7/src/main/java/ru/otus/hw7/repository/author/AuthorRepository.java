package ru.otus.hw7.repository.author;

import ru.otus.hw7.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
