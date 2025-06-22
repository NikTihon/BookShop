package org.example.bookshop.controller;

import org.example.bookshop.basket.Basket;
import org.example.bookshop.service.AuthorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/authors")
@Controller
public class AuthorController {

    private final AuthorService authorService;
    private final Basket basket;


    public AuthorController(AuthorService authorService, Basket basket) {
        this.authorService = authorService;
        this.basket = basket;
    }

    @GetMapping
    public String authors(Model model) {
        model.addAttribute("sum", basket.getSum());
        model.addAttribute("size", basket.getSize());
        model.addAttribute("authors", authorService.getAllAuthors());
        return "authors";
    }

    @GetMapping("/{attr}")
    public String author(Model model, @RequestParam("id") Integer id) {
        model.addAttribute("sum", basket.getSum());
        model.addAttribute("size", basket.getSize());
        model.addAttribute("author", authorService.getAuthorById(id));
        return "author";
    }

}
