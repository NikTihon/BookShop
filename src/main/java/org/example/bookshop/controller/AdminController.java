package org.example.bookshop.controller;

import org.example.bookshop.entity.Author;
import org.example.bookshop.entity.Book;
import org.example.bookshop.entity.Genre;
import org.example.bookshop.service.AuthorService;
import org.example.bookshop.service.BookService;
import org.example.bookshop.service.GenreService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


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
        model.addAttribute("authors", authorService.getAllAuthors());
        model.addAttribute("genres", genreService.getAllGenres());
        return "addBook";
    }

    @PostMapping("/addBook")
    public String addBook(Model model,
                          @ModelAttribute("book") Book book,
                          @RequestParam(value = "authorsId") List<Integer> authors,
                          @RequestParam(value = "genresId") List<Integer> genres) {
        System.out.println(book);
        int bookId = bookService.addNewBook(book, authors, genres);
        model.addAttribute("bookId", bookId);
        return "redirect:/addBook";
    }

    @GetMapping("/deleteAuthor")
    public String deleteAuthor(Model model) {
        model.addAttribute("authors", authorService.getAllAuthors());
        return "deleteAuthor";
    }

    @PostMapping("/deleteAuthor")
    public String deleteAuthor(@RequestParam("id") Integer id){
        System.out.println(id);
        authorService.deleteAuthor(id);
        return "redirect:/deleteAuthor";
    }

    @GetMapping("/addAuthor")
    public String addAuthor(Model model){
        model.addAttribute("author", new Author());
        return "addAuthor";
    }

    @PostMapping("/addAuthor")
    public String addAuthor(@ModelAttribute("author") Author author){
        authorService.addNewAuthor(author);
        return "redirect:/addAuthor";
    }

    @GetMapping("/addGenre")
    public String addGenre(Model model){
        model.addAttribute("genre", new Genre());
        return "addGenre";
    }

    @PostMapping("/addGenre")
    public String addGenre(@ModelAttribute("genre") Genre genre){
        genreService.AddNewGenre(genre);
        return "redirect:/addGenre";
    }

    @GetMapping("/deleteGenre")
    public String deleteGenre(Model model){
        model.addAttribute("genres", genreService.getAllGenres());
        return "/deleteGenre";
    }

    @PostMapping("/deleteGenre")
    public String deleteGenre(@RequestParam("id") Integer id){
        System.out.println(id);
        genreService.deleteGenre(id);
        return "redirect:/deleteGenre";
    }
}
