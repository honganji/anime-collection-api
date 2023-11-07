package com.example.animecollectionapiv2.repository;

import com.example.animecollectionapiv2.entity.Character;

import java.util.List;
import java.util.Map;

public interface CharacterRepository {
    boolean create(Character character);
    public List<Map<String, Object>> getByAnimeId(Long id);
    boolean update(Long id, Character anime);
    boolean delete(Long id);
}
