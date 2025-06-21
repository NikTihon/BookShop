package org.example.bookshop.controller;

import org.example.bookshop.entity.Book;
import org.example.bookshop.entity.DescriptionBook;
import org.example.bookshop.service.AuthorService;
import org.example.bookshop.service.BookService;
import org.example.bookshop.service.GenreService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;

@Controller
public class AdminController {
    private final String login = "login";
    private final String password = "password";
    private final BookService bookService;
    private final AuthorService authorService;
    private final GenreService genreService;

    public AdminController(BookService bookService, AuthorService authorService, GenreService genreService) {
        this.bookService = bookService;
        this.authorService = authorService;
        this.genreService = genreService;
    }

    @GetMapping("/admin")
    public String admin(@RequestParam String login, @RequestParam String password) {
        return (this.login.equals(login) && this.password.equals(password)) ? "admin" : "redirect:books";
    }

    @GetMapping("/addBook")
    public String addBook(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("descriptionBook", new DescriptionBook());
        model.addAttribute("authors", authorService.getAllAuthors());
        model.addAttribute("genres", genreService.getAllGenres());
        return "addBook";
    }

    @PostMapping("/addBook")
    public String addBook(@ModelAttribute("book") Book book,
                          @ModelAttribute("descriptionBook") DescriptionBook descriptionBook,
                          @RequestParam(value = "authorsId") List<Integer> authors,
                          @RequestParam(value = "genresId") List<Integer> genres) {
        System.out.println(book.getName());
        System.out.println(book.getImage());
        System.out.println(book.getPrice());
        authors.forEach(System.out::println);
        genres.forEach(System.out::println);
        System.out.println(descriptionBook.getBookId());
        System.out.println(descriptionBook.getDescription());
        System.out.println(descriptionBook.getPublishingHouse());
        System.out.println(descriptionBook.getAgeLimit());
        System.out.println(descriptionBook.getPageSize());
        System.out.println(descriptionBook.getDateOfWriting());
        bookService.AddNewBook(book, descriptionBook, authors, genres);
        return "redirect:addBook";
    }


}
