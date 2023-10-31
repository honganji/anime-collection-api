package com.example.animecollectionapiv2.service;

import com.example.animecollectionapiv2.entity.AuthorWork;

public interface AuthorWorkService {
    boolean create(AuthorWork authorWork);
    AuthorWork selectById(Long id);
    boolean update(Long id, AuthorWork authorWork);
    boolean delete(Long id);
}
