package com.example.animecollectionapiv2.service;

import com.example.animecollectionapiv2.entity.Anime;
import com.example.animecollectionapiv2.repository.AnimeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimeServiceImpl implements AnimeService{
    private final AnimeRepository animeRepository;
    public AnimeServiceImpl(AnimeRepository animeRepository) {
        this.animeRepository = animeRepository;
    }

    @Override
    public List<Anime> findAll() {
        return animeRepository.selectAll();
    }

    @Override
    public Anime findById(Long id) {
        return animeRepository.selectById(id);
    }

    @Override
    public void create(Anime anime) {
        animeRepository.create(anime);
    }

    @Override
    public boolean update(Long id, Anime anime) { return animeRepository.update(id, anime); }
    @Override
    public boolean delete(Long id) { return animeRepository.delete(id); }
}
