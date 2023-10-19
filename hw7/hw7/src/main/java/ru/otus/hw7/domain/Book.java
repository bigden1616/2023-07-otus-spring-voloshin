package ru.otus.hw7.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.List;


@Data
@NoArgsConstructor
@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @NonNull
    @Column(name = "title")
    private String title;

    @NonNull
    @JoinColumn(name = "author_id")
    @ManyToOne
    private Author author;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;

    @OneToMany(mappedBy = "book", cascade = {CascadeType.ALL})
    private List<Comment> comments;

    public Book(long id, String title, Author author, Genre genre) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
    }
}
