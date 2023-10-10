package ru.otus.hw7.service.author;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.hw7.domain.Author;
import ru.otus.hw7.repository.author.AuthorRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorDao;

    @Transactional(readOnly = true)
    @Override
    public List<Author> getAllAuthors() {
        return authorDao.findAll();
    }

    @Transactional
    @Override
    public Author addAuthor(String firstName, String lastName) {
        var author = new Author(0, firstName, lastName);
        var id = authorDao.save(author).getId();
        return authorDao.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    @Override
    public Author getAuthor(long id) {
        return authorDao.findById(id).orElse(null);
    }
}
