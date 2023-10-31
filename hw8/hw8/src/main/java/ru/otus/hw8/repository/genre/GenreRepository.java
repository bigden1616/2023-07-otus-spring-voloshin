package ru.otus.hw8.repository.genre;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.otus.hw8.domain.Genre;

public interface GenreRepository extends MongoRepository<Genre, String> {
}