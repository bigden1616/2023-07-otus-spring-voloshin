package ru.otus.hw6.service.comment;

import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import ru.otus.hw6.domain.Comment;
import ru.otus.hw6.repository.comment.CommentRepository;
import ru.otus.hw6.service.book.BookService;

import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

    private final BookService bookService;

    @Transactional(readOnly = true)
    @Override
    public List<Comment> getCommentsForBook(long bookId) {
        var book = bookService.getBook(bookId);
        return book.getComments();
    }

    @Transactional(readOnly = true)
    @Override
    public Comment getById(long id) {
        return commentRepository.getById(id);
    }

    @Transactional
    @Override
    public Comment addComment(long bookId, String text) {
        var book = bookService.getBook(bookId);
        var comment = new Comment(0, text, book);
        var id = commentRepository.insert(comment);
        return commentRepository.getById(id);
    }
}
