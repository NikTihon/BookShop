package org.example.bookshop.controller;

import org.example.bookshop.basket.Basket;
import org.example.bookshop.entity.Book;
import org.example.bookshop.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/search")
@Controller
public class SearchController {

    private final BookService bookService;
    private final Basket basket;

    public SearchController(BookService bookService, Basket basket) {
        this.bookService = bookService;
        this.basket = basket;
    }

    @GetMapping
    public String search(Model model, String str) {
        model.addAttribute("size", basket.getSize());
        model.addAttribute("sum", basket.getSum());
        model.addAttribute("search", str);
        model.addAttribute("books", bookService.getAllBooksBySearch(str));
        return "search";
    }

    @PostMapping
    public String addSearch(Model model, String str, Integer id, String name, Integer price, String image) {
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

}
