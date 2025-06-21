package org.example.bookshop.entity;

import jakarta.persistence.*;

import java.sql.Date;


@Entity
@Table(name = "description_book")
public class DescriptionBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer book_id;
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

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "book_id", referencedColumnName = "id")
//    private Book book = new Book();

    public DescriptionBook() {
    }


    public DescriptionBook(String description,
                           String publishing_house,
                           Integer age_limit,
                           Integer page_size,
                           Date date_of_writing) {
        this.description = description;
        this.publishing_house = publishing_house;
        this.age_limit = age_limit;
        this.page_size = page_size;
        this.date_of_writing = date_of_writing;
    }


    public Integer getBookId() {
        return book_id;
    }

    public String getDescription() {
        return description;
    }

    public String getPublishingHouse() {
        return publishing_house;
    }

    public Integer getAgeLimit() {
        return age_limit;
    }

    public Integer getPageSize() {
        return page_size;
    }

    public Date getDateOfWriting() {
        return date_of_writing;
    }

    public void setBookId(Integer book_id) {
        this.book_id = book_id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPublishingHouse(String publishing_house) {
        this.publishing_house = publishing_house;
    }

    public void setAgeLimit(Integer age_limit) {
        this.age_limit = age_limit;
    }

    public void setPageSize(Integer page_size) {
        this.page_size = page_size;
    }

    public void setStringOfWriting(Date date_of_writing) {
        this.date_of_writing = date_of_writing;
    }

//    public void setBook(Book book){
//        this.book = book;
//    }
}
