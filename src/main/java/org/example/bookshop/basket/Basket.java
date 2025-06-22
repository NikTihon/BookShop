package org.example.bookshop.basket;

import org.example.bookshop.entity.Book;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
@SessionScope
public class Basket {
    private final List<Book> basket = new ArrayList<>();
    private Integer sum = 0;

    public Basket() {
    }

    public void add(Book book) {
        basket.add(book);
        sum += book.getPrice();
    }

    public void remove(Integer bookId) {
        Book book = basket.stream().filter(i -> {
            if (Objects.equals(i.getId(), bookId)) {
                sum -= i.getPrice();
                return true;
            }
            return false;
        }).findFirst().orElse(new Book());
        basket.remove(book);
    }

    public List<Book> getBasket() {
        return basket;
    }

    public Integer getSum() {
        return sum;
    }

    public Integer getSize() {
        return basket.size();
    }

}
