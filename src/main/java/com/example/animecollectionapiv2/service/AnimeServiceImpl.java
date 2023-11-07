package com.example.animecollectionapiv2.service;

import com.example.animecollectionapiv2.entity.Anime;
import com.example.animecollectionapiv2.repository.AnimeRepository;
import com.example.animecollectionapiv2.repository.AuthorWorkRepository;
import com.example.animecollectionapiv2.repository.CharacterRepository;
import com.example.animecollectionapiv2.repository.ImageRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class AnimeServiceImpl implements AnimeService{
    private final AnimeRepository animeRepository;
    private final AuthorWorkRepository authorWorkRepository;
    private final ImageRepository imageRepository;
    private final CharacterRepository characterRepository;
    public AnimeServiceImpl(
            AnimeRepository animeRepository,
            AuthorWorkRepository authorWorkRepository,
            ImageRepository imageRepository,
            CharacterRepository characterRepository) {
        this.animeRepository = animeRepository;
        this.authorWorkRepository = authorWorkRepository;
        this.imageRepository = imageRepository;
        this.characterRepository = characterRepository;
    }

    @Override
    public List<Map<String, Object>> findAll() {
        List<Map<String, Object>> finalJson = new ArrayList<Map<String, Object>>();
        List<Map<String, Object>> idJson = animeRepository.getAllId();
        idJson.forEach(id ->{
            finalJson.add(findById((Long) id.get("id")).get(0));
        });
        return finalJson;
    }

    @Override
    public List<Map<String, Object>> findById(Long id) {
        // List container
        List<String> authorWorkList = new ArrayList<String>();
        List<String> imageList = new ArrayList<String>();
        List<Map<String, Object>> characterList = new ArrayList<Map<String, Object>>();

        // fetch data as Json type
        List<Map<String, Object>> finalJson = animeRepository.selectById(id);
        List<Map<String, Object>> authorWorkJson = authorWorkRepository.getNameByAuthorId((Long) finalJson.get(0).get("author_id"));
        List<Map<String, Object>> imageJson = imageRepository.getNameByAnimeId((Long) finalJson.get(0).get("anime_id"));
        List<Map<String, Object>> characterJson = characterRepository.getByAnimeId((Long) finalJson.get(0).get("anime_id"));

        // input data into list container
        authorWorkJson.forEach(element -> authorWorkList.add((String) element.get("name")));
        imageJson.forEach(element -> imageList.add((String) element.get("url")));
        characterJson.forEach(element -> characterList.add(element));

        // insert each list into the final json data
        finalJson.get(0).put("author_works", authorWorkList);
        finalJson.get(0).put("images", imageList);
        finalJson.get(0).put("characters", characterList);

        return finalJson;
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
