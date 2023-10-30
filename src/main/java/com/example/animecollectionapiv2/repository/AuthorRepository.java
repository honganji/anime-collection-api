package com.example.animecollectionapiv2.repository;

import com.example.animecollectionapiv2.entity.Author;

public interface AuthorRepository {
    boolean create(Author author);
    Author selectById(Long id);
    boolean update(Long id, Author author);
    boolean delete(Long id);
}
