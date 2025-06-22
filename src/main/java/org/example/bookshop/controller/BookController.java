package org.example.bookshop.controller;


import org.example.bookshop.basket.Basket;
import org.example.bookshop.entity.Book;
import org.example.bookshop.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class BookController {

    private final BookService bookService;
    private final Basket basket;

    public BookController(BookService bookService, Basket basket) {
        this.basket = basket;
        this.bookService = bookService;
    }


    @GetMapping("/books")
    public String books(Model model) {
        model.addAttribute("sum", basket.getSum());
        model.addAttribute("size", basket.getSize());
        model.addAttribute("books", bookService.getAllBooks());
        return "books";
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


    @GetMapping("/book/{attr}")
    public String book(Model model,
                       @RequestParam Integer id) {
        Book book = bookService.getBookById(id);
        model.addAttribute("sum", basket.getSum());
        model.addAttribute("size", basket.getSize());
        model.addAttribute("book", book);
        model.addAttribute("authors", book.getAuthors());
        model.addAttribute("genres", book.getGenres());
        return "book";
    }
}
