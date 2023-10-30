package com.example.animecollectionapiv2.service;

import com.example.animecollectionapiv2.entity.Author;
import com.example.animecollectionapiv2.repository.AuthorRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService{
    private final AuthorRepository authorRepository;
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public boolean create(Author newAuthor) { return authorRepository.create(newAuthor); }

    @Override
    public Author findById(Long id) { return authorRepository.selectById(id); }

    @Override
    public boolean update(Long id, Author newAuthor) { return authorRepository.update(id, newAuthor); }

    @Override
    public boolean delete(Long id) { return authorRepository.delete(id); }
}
