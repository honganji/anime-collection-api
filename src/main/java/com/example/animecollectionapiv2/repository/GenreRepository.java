package com.example.animecollectionapiv2.repository;

import com.example.animecollectionapiv2.entity.Anime;
import com.example.animecollectionapiv2.entity.Genre;

import java.util.List;
import java.util.Map;

public interface GenreRepository {
    boolean create(Genre genre);
    boolean update(Long id, Genre genre);
    boolean delete(Long id);
}
