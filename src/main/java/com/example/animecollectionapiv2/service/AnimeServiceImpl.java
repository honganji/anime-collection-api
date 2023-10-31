package com.example.animecollectionapiv2.service;

import com.example.animecollectionapiv2.entity.Anime;
import com.example.animecollectionapiv2.repository.AnimeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AnimeServiceImpl implements AnimeService{
    private final AnimeRepository animeRepository;
    public AnimeServiceImpl(AnimeRepository animeRepository) {
        this.animeRepository = animeRepository;
    }

    @Override
    public List<Map<String, Object>> findAll() {
        return animeRepository.selectAll();
    }

    @Override
    public List<Map<String, Object>> findById(Long id) {
        return animeRepository.selectById(id);
    }

    @Override
    public boolean create(Anime anime) {
        return animeRepository.create(anime);
    }

    @Override
    public boolean update(Long id, Anime anime) { return animeRepository.update(id, anime); }
    @Override
    public boolean delete(Long id) { return animeRepository.delete(id); }
}
