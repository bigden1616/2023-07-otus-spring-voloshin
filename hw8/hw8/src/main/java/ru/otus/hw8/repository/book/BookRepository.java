package ru.otus.hw8.repository.book;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.otus.hw8.domain.Book;

public interface BookRepository extends MongoRepository<Book, String> {
}