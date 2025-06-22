package org.example.bookshop.controller;

import org.example.bookshop.basket.Basket;
import org.example.bookshop.service.GenreService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/genres")
@Controller
public class GenreController {

    private final GenreService genreService;
    private final Basket basket;


    public GenreController(GenreService genreService, Basket basket) {
        this.genreService = genreService;
        this.basket = basket;
    }

    @GetMapping
    public String genres(Model model) {
        model.addAttribute("sum", basket.getSum());
        model.addAttribute("size", basket.getSize());
        model.addAttribute("genres", genreService.getAllGenres());
        return "genres";
    }

    @GetMapping("/{attr}")
    public String genre(Model model, @RequestParam("id") Integer id) {
        model.addAttribute("sum", basket.getSum());
        model.addAttribute("size", basket.getSize());
        model.addAttribute("genre", genreService.getGenreById(id));
        return "genre";
    }


}
