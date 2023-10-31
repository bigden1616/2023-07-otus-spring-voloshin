package ru.otus.hw8.repository.author;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.otus.hw8.domain.Author;

public interface AuthorRepository extends MongoRepository<Author, String> {
}
