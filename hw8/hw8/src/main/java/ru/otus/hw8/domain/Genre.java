package ru.otus.hw8.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collation = "genres")
public class Genre {

    @Id
    private String id;

    @NonNull
    private String name;

    public Genre(@NonNull String name) {
        this.name = name;
    }
}
