package com.example.animecollectionapiv2.service;

import com.example.animecollectionapiv2.entity.Image;

public interface ImageService {
    boolean create(Image image);
    boolean update(Long id, Image image);
    boolean delete(Long id);
}
