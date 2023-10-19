package ru.otus.hw7.repository.genre;

import ru.otus.hw7.domain.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Long> {
}