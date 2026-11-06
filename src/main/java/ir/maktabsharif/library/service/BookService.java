package ir.maktabsharif.library.service;

import ir.maktabsharif.library.exception.BusinessException;
import ir.maktabsharif.library.model.Book;

import java.util.List;

public interface BookService {
    void create(Book book);
    List<Book> findAll();
    Book findById(Long id) throws BusinessException;
}
