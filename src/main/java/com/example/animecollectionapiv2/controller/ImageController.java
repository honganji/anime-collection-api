package com.example.animecollectionapiv2.controller;

import com.example.animecollectionapiv2.entity.Image;
import com.example.animecollectionapiv2.service.ImageService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/images")
public class ImageController {
    private final ImageService imageService;
    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @PostMapping
    public String create(@RequestBody Image newImage) {
        boolean isSucceed = imageService.create(newImage);
        return isSucceed ? "The creation is done successfully!" : "The creation is failed";
    }

    @PutMapping("/{id}")
    public String update(@PathVariable Long id, @RequestBody Image newImage) {
        boolean isSucceed = imageService.update(id, newImage);
        return isSucceed ? "The update is done successfully!" : "The update is failed";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        boolean isSucceed = imageService.delete(id);
        return isSucceed ? "The deletion is done successfully!" : "The deletion is failed";
    }
}
