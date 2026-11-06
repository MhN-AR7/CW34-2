package ir.maktabsharif.library.repo.impl;

import ir.maktabsharif.library.model.Book;
import ir.maktabsharif.library.repo.BookRepo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class BookRepoImpl implements BookRepo {
    private final static List<Book> books = new ArrayList<>();

    static {
        books.add(new Book(1L, "Java", "Ali Najafi", 2026));
        books.add(new Book(2L, "Python", "Ali Noori", 2020));
        books.add(new Book(3L, "C++", "Ali Moradi", 2023));
    }

    @Override
    public void create(Book book) {
        if (book.getId() == null) {
            book.setId(books.size()+1L);
        }

        books.add(book);
    }

    @Override
    public List<Book> findAll() {
        return books;
    }

    @Override
    public Optional<Book> findById(Long id) {
        return books.stream()
                .filter(book -> book.getId().equals(id))
                .findFirst();
    }
}
