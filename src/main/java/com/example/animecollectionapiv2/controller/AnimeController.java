package com.example.animecollectionapiv2.controller;

import com.example.animecollectionapiv2.entity.Anime;
import com.example.animecollectionapiv2.service.AnimeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("http://localhost:3000")
public class AnimeController {
    private final AnimeService animeService;
    public AnimeController(AnimeService animeService) {
        this.animeService = animeService;
    }

    @PostMapping("/api/anime")
    public String create(@RequestBody Anime newAnime) {
        boolean isSucceed = animeService.create(newAnime);
        return isSucceed ? "The creation is done successfully!" : "The creation is failed";
    }
    @GetMapping("/api/animes")
    public List<Map<String, Object>> getAll() {
        return animeService.findAll();
    }

    @GetMapping("/api/animes/{id}")
    public List<Map<String, Object>> get(@PathVariable Long id) {
        return animeService.findById(id);
    }

    @PutMapping("/api/animes/{id}")
    public String update(@PathVariable Long id, @RequestBody Anime newAnime) {
        boolean isSucceed = animeService.update(id, newAnime);
        return isSucceed ? "The update is done successfully!" : "The update is failed";
    }

    @DeleteMapping("/api/animes/{id}")
    public String delete(@PathVariable Long id) {
        boolean isSucceed = animeService.delete(id);
        return isSucceed ? "The deletion is done successfully!" : "The deletion is failed";
    }
}
