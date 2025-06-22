package org.example.bookshop.controller;

import org.example.bookshop.basket.Basket;
import org.example.bookshop.entity.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BasketController {
    private final Basket basket;

    public BasketController(Basket basket) {
        this.basket = basket;
    }

    @GetMapping("/basket")
    public String basket(Model model) {
        model.addAttribute("sum", basket.getSum());
        model.addAttribute("basket", basket.getBasket());
        return "basket";
    }

    @PostMapping("/basket")
    public String removeBasket(Integer id) {
        basket.remove(id);
        return "redirect:/basket";
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
}
