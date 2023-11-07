package com.example.animecollectionapiv2.repository;

import com.example.animecollectionapiv2.entity.Author;

import java.util.List;
import java.util.Map;

public interface AuthorRepository {
    boolean create(Author author);
    Author selectById(Long id);
    boolean update(Long id, Author author);
    boolean delete(Long id);
}
