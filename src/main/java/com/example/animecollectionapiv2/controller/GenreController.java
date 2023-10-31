package com.example.animecollectionapiv2.controller;

import com.example.animecollectionapiv2.entity.Genre;
import com.example.animecollectionapiv2.service.GenreService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/genres")
public class GenreController {
    private final GenreService genreService;
    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @PostMapping
    public String create(@RequestBody Genre newGenre) {
        boolean isSucceed = genreService.create(newGenre);
        return isSucceed ? "The creation is done successfully!" : "The creation is failed";
    }

    @PutMapping("/{id}")
    public String update(@PathVariable Long id, @RequestBody Genre newGenre) {
        boolean isSucceed = genreService.update(id, newGenre);
        return isSucceed ? "The update is done successfully!" : "The update is failed";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        boolean isSucceed = genreService.delete(id);
        return isSucceed ? "The deletion is done successfully!" : "The deletion is failed";
    }
}
