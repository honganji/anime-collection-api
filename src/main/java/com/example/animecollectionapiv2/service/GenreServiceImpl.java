package com.example.animecollectionapiv2.service;

import com.example.animecollectionapiv2.entity.Genre;
import com.example.animecollectionapiv2.repository.GenreRepository;
import org.springframework.stereotype.Service;

@Service
public class GenreServiceImpl implements GenreService{
    private final GenreRepository genreRepository;
    public GenreServiceImpl(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Override
    public boolean create(Genre newGenre) { return genreRepository.create(newGenre); }

    @Override
    public boolean update(Long id, Genre newGenre) { return genreRepository.update(id, newGenre); }

    @Override
    public boolean delete(Long id) { return genreRepository.delete(id); }
}
