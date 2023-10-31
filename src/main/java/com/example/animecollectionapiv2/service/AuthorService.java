package com.example.animecollectionapiv2.service;

import com.example.animecollectionapiv2.entity.Anime;
import com.example.animecollectionapiv2.entity.Author;

import java.util.List;

public interface AuthorService {
    boolean create(Author author);
    Author findById(Long id);
    boolean update(Long id, Author author);
    boolean delete(Long id);

}
