package org.example.bookshop.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String name;
    @Column
    private String image;
    @Column(nullable = false)
    private Integer price;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "list_of_authors",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id"))
    private List<Author> authors = new ArrayList<>();

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "list_of_genres",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private List<Genre> genres = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id", referencedColumnName = "book_id")
    private DescriptionBook descriptionBook = new DescriptionBook();

    public Book() {

    }

    public Book(String name, String image, Integer price, List<Author> authors, List<Genre> genres) {
        this.name = name;
        this.image = image;
        this.price = price;
        this.authors = authors;
        this.genres = genres;
    }

    public Book(Book book, DescriptionBook descriptionBook) {
        this.name = book.getName();
        this.image = book.getImage();
        this.price = book.getPrice();
        this.descriptionBook = descriptionBook;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }


    public Integer getPrice() {
        return price;
    }


    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImage(String image) {
        this.image = image;
    }


    public void setPrice(Integer price) {
        this.price = price;
    }


    public List<Author> getAuthors() {
        return authors;
    }

    public List<Genre> getGenres() {
        return genres;
    }


    public DescriptionBook getDescriptionBook() {
        return descriptionBook;
    }
}
