package ru.otus.hw8.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;


@Data
@NoArgsConstructor
@Document(collation = "books")
public class Book {

    @Id
    private String id;

    @NonNull
    private String title;

    @NonNull
    private Author author;

    @NonNull
    private Genre genre;

    private List<Comment> comments;

    public Book(String title, Author author, Genre genre) {
        this.title = title;
        this.author = author;
        this.genre = genre;
    }

    public Book(String id, String title, Author author, Genre genre) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
    }
}
