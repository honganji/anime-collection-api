package com.example.animecollectionapiv2.service;

import com.example.animecollectionapiv2.entity.Anime;
import com.example.animecollectionapiv2.entity.Genre;

public interface GenreService {
    boolean create(Genre genre);
    boolean update(Long id, Genre genre);
    boolean delete(Long id);
}
