package com.example.animecollectionapiv2.repository;

import com.example.animecollectionapiv2.entity.Genre;
import com.example.animecollectionapiv2.entity.Image;

public interface ImageRepository {
    boolean create(Image image);
    boolean update(Long id, Image image);
    boolean delete(Long id);
}
