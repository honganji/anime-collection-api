package com.example.animecollectionapiv2.service;

import com.example.animecollectionapiv2.entity.Character;

public interface CharacterService {
    boolean create(Character character);
    boolean update(Long id, Character character);
    boolean delete(Long id);
}
