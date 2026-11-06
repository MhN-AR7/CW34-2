package ir.maktabsharif.library.service.impl;

import ir.maktabsharif.library.exception.BusinessException;
import ir.maktabsharif.library.exception.EntityNotFoundException;
import ir.maktabsharif.library.model.Book;
import ir.maktabsharif.library.repo.BookRepo;
import ir.maktabsharif.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepo bookRepo;

    @Autowired
    public BookServiceImpl(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    @Override
    public void create(Book book) {
        bookRepo.create(book);
    }

    @Override
    public List<Book> findAll() {
        return bookRepo.findAll();
    }

    @Override
    public Book findById(Long id) throws BusinessException {
        return bookRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Book not found!"));
    }
}
