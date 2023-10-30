package com.example.animecollectionapiv2.repository;

import com.example.animecollectionapiv2.entity.Anime;

import java.util.List;

public interface AnimeRepository {
    boolean create(Anime anime);
    Anime selectById(Long id);
    List<Anime> selectAll();
    boolean update(Long id, Anime anime);
    boolean delete(Long id);
}
