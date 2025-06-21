package org.example.bookshop.service;


import org.example.bookshop.entity.Book;
import org.example.bookshop.entity.DescriptionBook;
import org.example.bookshop.repository.AuthorRepository;
import org.example.bookshop.repository.DescriptionBookRepository;
import org.example.bookshop.repository.GenreRepository;
import org.springframework.stereotype.Service;
import org.example.bookshop.repository.BookRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    private final DescriptionBookRepository descriptionBookRepository;
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final GenreRepository genreRepository;

    public BookService(BookRepository bookRepository, AuthorRepository authorRepository, GenreRepository genreRepository, DescriptionBookRepository descriptionBookRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.genreRepository = genreRepository;
        this.descriptionBookRepository = descriptionBookRepository;
    }

    @Transactional
    public List<Book> getAllBooks() {
        try {
            return bookRepository.findAll();
        } catch (Exception e) {
            System.out.println("Ошибка при вызове getAllBooks(): " + e.getMessage());
            return new ArrayList<>();
        }
    }

    @Transactional
    public Book getBookById(Integer id) {
        return bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
    }

    @Transactional
    public List<Book> getAllBooksBySearch(String str) {
        return bookRepository.findByNameContains(str);
    }

    @Transactional
    public void AddNewBook(Book book,
                           DescriptionBook descriptionBook,
                           List<Integer> authors, List<Integer> genres) {
        authors.forEach(i -> book.getAuthors().add(authorRepository.findById(i)
                .orElseThrow(() -> new RuntimeException("Author not found"))));
        genres.forEach(i -> book.getGenres().add(genreRepository.findById(i)
                .orElseThrow(() -> new RuntimeException("Genre not found"))));
        //descriptionBookRepository.save(descriptionBook);
        bookRepository.save(new Book(book, descriptionBook));
    }
}
