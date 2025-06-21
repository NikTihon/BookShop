package org.example.bookshop.service;

import org.example.bookshop.entity.Genre;
import org.example.bookshop.repository.GenreRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class GenreService {
    private final GenreRepository genreRepository;

    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Transactional
    public List<Genre> getAllGenres() {
        try {
            return genreRepository.findAll();
        } catch (Exception e) {
            System.out.println("Ошибка при вывзове getAllGenres" + e.getMessage());
            return new ArrayList<>();
        }
    }

    @Transactional
    public Genre getGenreById(Integer id) {
        return genreRepository.findById(id).orElseThrow(() -> new RuntimeException("Genre not found"));
    }

    @Transactional
    public void AddNewGenre(Genre genre){
        genreRepository.save(genre);
    }
}
