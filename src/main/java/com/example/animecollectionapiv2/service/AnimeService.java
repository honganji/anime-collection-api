package com.example.animecollectionapiv2.service;

import com.example.animecollectionapiv2.entity.Anime;

import java.util.List;
import java.util.Map;

public interface AnimeService {
    List<Map<String, Object>> findAll();
    List<Map<String, Object>> findById(Long id);
    boolean create(Anime anime);
    boolean update(Long id, Anime anime);
    boolean delete(Long id);
}
