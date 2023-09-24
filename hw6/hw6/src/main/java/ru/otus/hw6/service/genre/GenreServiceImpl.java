package ru.otus.hw6.service.genre;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import ru.otus.hw6.dao.genre.GenreDao;
import ru.otus.hw6.domain.Genre;

import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class GenreServiceImpl implements GenreService {

    private final GenreDao genreDao;

    @Override
    public List<Genre> getAllGenres() {
        return genreDao.getAll();
    }

    @Override
    public Genre addGenre(String name) {
        var genre = new Genre(0, name);
        var id = genreDao.insert(genre);
        return genreDao.getById(id);
    }

    @Override
    public Genre getGenre(long id) {
        return genreDao.getById(id);
    }
}
