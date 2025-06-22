package org.example.bookshop.controller;


import org.example.bookshop.basket.Basket;
import org.example.bookshop.entity.Book;
import org.example.bookshop.service.AuthorService;
import org.example.bookshop.service.BookService;
import org.example.bookshop.service.GenreService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {
    private final AuthorService authorService;
    private final GenreService genreService;
    private final BookService bookService;
    private final Basket basket;

    public MainController(BookService bookService, Basket basket, GenreService genreService, AuthorService authorService) {
        this.basket = basket;
        this.bookService = bookService;
        this.genreService = genreService;
        this.authorService = authorService;
    }


    @GetMapping("/search")
    public String search(Model model, String str) {
        model.addAttribute("size", basket.getSize());
        model.addAttribute("sum", basket.getSum());
        model.addAttribute("search", str);
        model.addAttribute("books", bookService.getAllBooksBySearch(str));
        return "search";
    }

    @PostMapping("/search")
    public String addSearch(Model model, String str,Integer id, String name, Integer price, String image) {
        Book book = new Book();
        book.setId(id);
        book.setName(name);
        book.setPrice(price);
        book.setImage(image);
        basket.add(book);
        model.addAttribute("size", basket.getSize());
        model.addAttribute("sum", basket.getSum());
        model.addAttribute("search", str);
        model.addAttribute("books", bookService.getAllBooksBySearch(str));
        return "search";
    }

    @GetMapping("/{attr}")
    public String books(Model model, @PathVariable String attr) {
        model.addAttribute("sum", basket.getSum());
        model.addAttribute("size", basket.getSize());

        return switch (attr) {
            case "genres" -> {
                model.addAttribute("genres", genreService.getAllGenres());
                yield "genres";
            }
            case "authors" -> {
                model.addAttribute("authors", authorService.getAllAuthors());
                yield "authors";
            }
            case "books" -> {
                model.addAttribute("books", bookService.getAllBooks());
                yield "books";
            }
            default -> "books";
        };
    }

    @PostMapping("/books")
    public String addBasket(Integer id, String name, Integer price, String image) {
        Book book = new Book();
        book.setId(id);
        book.setName(name);
        book.setPrice(price);
        book.setImage(image);
        basket.add(book);
        return "redirect:books";
    }

    @PostMapping("/{attr1}/{attr2}")
    public String addBasket(@RequestParam Integer id,
                            @PathVariable String attr1,
                            @PathVariable String attr2,
                            Integer AddId, String name, Integer price, String image) {
        Book book = new Book();
        book.setId(AddId);
        book.setName(name);
        book.setPrice(price);
        book.setImage(image);
        basket.add(book);
        return "redirect:/{attr1}/{attr2}?id=" + id;
    }

    @GetMapping("/{attr1}/{attr2}")
    public String author(Model model,
                         @RequestParam Integer id,
                         @PathVariable String attr1,
                         @PathVariable String attr2) {
        model.addAttribute("sum", basket.getSum());
        model.addAttribute("size", basket.getSize());
        return switch (attr1) {
            case "genres" -> {
                model.addAttribute("genre", genreService.getGenreById(id));
                yield "genre";
            }
            case "authors" -> {
                model.addAttribute("author", authorService.getAuthorById(id));
                yield "author";
            }
            default -> "books";
        };
    }


    @GetMapping("/book/{attr}")
    public String book(Model model,
                       @PathVariable String attr,
                       @RequestParam Integer id){
        Book book = bookService.getBookById(id);
        model.addAttribute("sum", basket.getSum());
        model.addAttribute("size", basket.getSize());
        model.addAttribute("book", book);
        model.addAttribute("authors", book.getAuthors());
        model.addAttribute("genres", book.getGenres());
        return "book";
    }
}
