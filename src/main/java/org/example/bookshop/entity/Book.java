package org.example.bookshop.entity;

import jakarta.persistence.*;

import java.sql.Date;
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
    @Column
    private String description;
    @Column
    private String publishing_house;
    @Column
    private Integer age_limit;
    @Column
    private Integer page_size;
    @Column
    private Date date_of_writing;

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


    public Book() {

    }

    public Book(String name, String image,
                Integer price, String description,
                String publishing_house, Integer age_limit,
                Integer page_size, Date date_of_writing,
                List<Author> authors, List<Genre> genres) {
        this.name = name;
        this.image = image;
        this.price = price;
        this.description = description;
        this.publishing_house = publishing_house;
        this.age_limit = age_limit;
        this.page_size = page_size;
        this.date_of_writing = date_of_writing;
        this.authors = authors;
        this.genres = genres;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPublishingHouse() {
        return publishing_house;
    }

    public void setPublishingHouse(String publishing_house) {
        this.publishing_house = publishing_house;
    }

    public Integer getAgeLimit() {
        return age_limit;
    }

    public void setAgeLimit(Integer age_limit) {
        this.age_limit = age_limit;
    }

    public Integer getPageSize() {
        return page_size;
    }

    public void setPageSize(Integer page_size) {
        this.page_size = page_size;
    }

    public Date getDateOfWriting() {
        return date_of_writing;
    }

    public void setDateOfWriting(Date date_of_writing) {
        this.date_of_writing = date_of_writing;
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

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", publishing_house='" + publishing_house + '\'' +
                ", age_limit=" + age_limit +
                ", page_size=" + page_size +
                ", date_of_writing=" + date_of_writing +
                ", authors=" + authors +
                ", genres=" + genres +
                '}';
    }

}
