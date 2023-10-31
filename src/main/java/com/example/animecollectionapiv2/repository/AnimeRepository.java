package com.example.animecollectionapiv2.repository;

import com.example.animecollectionapiv2.entity.Anime;

import java.util.List;
import java.util.Map;

public interface AnimeRepository {
    boolean create(Anime anime);
    List<Map<String, Object>> selectById(Long id);
    List<Map<String, Object>> selectAll();
    boolean update(Long id, Anime anime);
    boolean delete(Long id);
}
