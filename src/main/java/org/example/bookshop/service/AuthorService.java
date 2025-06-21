package org.example.bookshop.service;


import org.example.bookshop.entity.Author;
import org.example.bookshop.repository.AuthorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Transactional
    public List<Author> getAllAuthors() {
        try {
            return authorRepository.findAll();
        } catch (Exception e) {
            System.out.println("Ошибка при вызове getAllAuthors(): " + e.getMessage());
            return new ArrayList<>();
        }
    }

    @Transactional
    public Author getAuthorById(Integer id) {
        return authorRepository.findById(id).orElseThrow(() -> new RuntimeException("Author not found"));
    }

    @Transactional
    public void addNewAuthor(Author author) {
        authorRepository.save(author);
    }
}
