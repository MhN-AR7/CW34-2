package ir.maktabsharif.library.repo;

import ir.maktabsharif.library.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepo {
    void create(Book book);
    List<Book> findAll();
    Optional<Book> findById(Long id);
}
