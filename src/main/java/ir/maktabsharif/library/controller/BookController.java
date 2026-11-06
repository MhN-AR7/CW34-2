package ir.maktabsharif.library.controller;

import ir.maktabsharif.library.exception.BusinessException;
import ir.maktabsharif.library.model.Book;
import ir.maktabsharif.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping({"", "/", "/all"})
    public String getAllBooks(Model model) {
        model.addAttribute("books", bookService.findAll());
        return "all-books";
    }

    @GetMapping("/add")
    public String getForm() {
        return "form";
    }

    @PostMapping("/add")
    public ResponseEntity<String> addBook(
            @RequestParam("title") String title,
            @RequestParam("author") String author,
            @RequestParam("publishedYear") Integer publishedYear
    ) {
        Book book = Book.builder()
                .title(title)
                .author(author)
                .publishedYear(publishedYear)
                .build();

        bookService.create(book);

        return ResponseEntity.status(HttpStatus.CREATED).body(book.toString());

//        return "redirect:all";
    }

    @RequestMapping("/{id}")
    public ModelAndView getById(
            @PathVariable("id") Long id
    ) {
        ModelAndView modelAndView;
        try {
            Book book = bookService.findById(id);
            modelAndView = new ModelAndView("found");
            modelAndView.addObject("book", book);
            modelAndView.setStatus(HttpStatus.OK);
        } catch (BusinessException e) {
            modelAndView = new ModelAndView("exception");
            modelAndView.addObject("excMessage", e.getMessage());
            modelAndView.setStatus(HttpStatus.NOT_FOUND);
        }

        return modelAndView;
    }
}
