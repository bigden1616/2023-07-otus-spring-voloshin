package ru.otus.hw6.service.genre;

import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import ru.otus.hw6.repository.genre.GenreRepository;
import ru.otus.hw6.domain.Genre;

import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class GenreServiceImpl implements GenreService {

    private final GenreRepository genreRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Genre> getAllGenres() {
        return genreRepository.getAll();
    }

    @Transactional
    @Override
    public Genre addGenre(String name) {
        var genre = new Genre(0, name);
        var id = genreRepository.insert(genre);
        return genreRepository.getById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public Genre getGenre(long id) {
        return genreRepository.getById(id);
    }
}
