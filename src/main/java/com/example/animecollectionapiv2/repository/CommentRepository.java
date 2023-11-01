package com.example.animecollectionapiv2.repository;

import com.example.animecollectionapiv2.entity.Anime;
import com.example.animecollectionapiv2.entity.Comment;

import java.util.List;
import java.util.Map;

public interface CommentRepository {
    boolean create(Comment comment);
    List<Map<String, Object>> selectById(Long id);
    boolean update(Long id, Comment comment);
    boolean delete(Long id);
}
