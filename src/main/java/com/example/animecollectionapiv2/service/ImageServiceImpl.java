package com.example.animecollectionapiv2.service;

import com.example.animecollectionapiv2.entity.Image;
import com.example.animecollectionapiv2.repository.ImageRepository;
import org.springframework.stereotype.Service;

@Service
public class ImageServiceImpl implements ImageService{
    private  final ImageRepository imageRepository;
    public ImageServiceImpl(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    @Override
    public boolean create(Image newImage) { return imageRepository.create(newImage); }

    @Override
    public boolean update(Long id, Image newImage) { return imageRepository.update(id, newImage); }

    @Override
    public boolean delete(Long id) { return imageRepository.delete(id); }
}
