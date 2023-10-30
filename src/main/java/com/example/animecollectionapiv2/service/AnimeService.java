package com.example.animecollectionapiv2.service;

import com.example.animecollectionapiv2.entity.Anime;

import java.util.List;

public interface AnimeService {
    List<Anime> findAll();
    Anime findById(Long id);
    void create(Anime anime);
    boolean update(Long id, Anime anime);
    boolean delete(Long id);
}
