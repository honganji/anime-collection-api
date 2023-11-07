package com.example.animecollectionapiv2.repository;

import com.example.animecollectionapiv2.entity.AuthorWork;

import java.util.List;
import java.util.Map;

public interface AuthorWorkRepository {
    boolean create(AuthorWork authorWork);
    AuthorWork selectById(Long id);
    List<Map<String, Object>> getNameByAuthorId(Long id);
    boolean update(Long id, AuthorWork authorWork);
    boolean delete(Long id);
}
