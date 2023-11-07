package com.example.animecollectionapiv2.repository;

import com.example.animecollectionapiv2.entity.Genre;
import com.example.animecollectionapiv2.entity.Image;

import java.util.List;
import java.util.Map;

public interface ImageRepository {
    boolean create(Image image);
    public List<Map<String, Object>> getNameByAnimeId(Long id);
    boolean update(Long id, Image image);
    boolean delete(Long id);
}
