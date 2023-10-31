package com.example.animecollectionapiv2.service;

import com.example.animecollectionapiv2.entity.AuthorWork;
import com.example.animecollectionapiv2.repository.AuthorWorkRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthorWorkServiceImpl implements AuthorWorkService{
    private final AuthorWorkRepository authorWorkRepository;
    public AuthorWorkServiceImpl(AuthorWorkRepository authorWorkRepository) {
        this.authorWorkRepository = authorWorkRepository;
    }

    @Override
    public boolean create(AuthorWork authorWork) {
        return authorWorkRepository.create(authorWork);
    }

    @Override
    public AuthorWork selectById(Long id) {
        return authorWorkRepository.selectById(id);
    }

    @Override
    public boolean update(Long id, AuthorWork authorWork) {
        return authorWorkRepository.update(id, authorWork);
    }

    @Override
    public boolean delete(Long id) {
        return authorWorkRepository.delete(id);
    }

}
