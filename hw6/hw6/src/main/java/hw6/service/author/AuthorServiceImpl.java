package hw6.service.author;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import ru.otus.hw5.dao.author.AuthorDao;
import ru.otus.hw5.domain.Author;

import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class AuthorServiceImpl implements AuthorService {

    private final AuthorDao authorDao;

    @Override
    public List<Author> getAllAuthors() {
        return authorDao.getAll();
    }

    @Override
    public Author addAuthor(String firstName, String lastName) {
        var author = new Author(0, firstName, lastName);
        var id = authorDao.insert(author);
        return authorDao.getById(id);
    }

    @Override
    public Author getAuthor(long id) {
        return authorDao.getById(id);
    }
}
