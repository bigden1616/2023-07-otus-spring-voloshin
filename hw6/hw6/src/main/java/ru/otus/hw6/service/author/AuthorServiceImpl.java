package ru.otus.hw6.service.author;

import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import ru.otus.hw6.repository.author.AuthorRepository;
import ru.otus.hw6.domain.Author;

import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorDao;

    @Transactional(readOnly = true)
    @Override
    public List<Author> getAllAuthors() {
        return authorDao.getAll();
    }

    @Transactional
    @Override
    public Author addAuthor(String firstName, String lastName) {
        var author = new Author(0, firstName, lastName);
        var id = authorDao.insert(author);
        return authorDao.getById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public Author getAuthor(long id) {
        return authorDao.getById(id);
    }
}
