package ru.otus.hw8.service.comment;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.hw8.domain.Comment;
import ru.otus.hw8.repository.comment.CommentRepository;
import ru.otus.hw8.service.book.BookService;

import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

    private final BookService bookService;

    @Transactional(readOnly = true)
    @Override
    public List<Comment> getCommentsForBook(String bookId) {
        var book = bookService.getBook(bookId);
        return book.getComments().stream().toList();
    }

    @Transactional(readOnly = true)
    @Override
    public Comment getById(String id) {
        return commentRepository.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public Comment addComment(String bookId, String text) {
        var book = bookService.getBook(bookId);
        var comment = new Comment(text, book);
        return commentRepository.save(comment);
    }
}
