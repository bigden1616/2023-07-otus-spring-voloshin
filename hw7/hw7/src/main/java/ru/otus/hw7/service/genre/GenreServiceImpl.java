package ru.otus.hw7.service.genre;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.hw7.domain.Genre;
import ru.otus.hw7.repository.genre.GenreRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class GenreServiceImpl implements GenreService {

    private final GenreRepository genreRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Genre> getAllGenres() {
        return genreRepository.findAll();
    }

    @Transactional
    @Override
    public Genre addGenre(String name) {
        var genre = new Genre(0, name);
        var id = genreRepository.save(genre).getId();
        return genreRepository.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    @Override
    public Genre getGenre(long id) {
        return genreRepository.findById(id).orElse(null);
    }
}
