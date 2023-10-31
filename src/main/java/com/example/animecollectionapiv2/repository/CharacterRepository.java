package com.example.animecollectionapiv2.repository;

import com.example.animecollectionapiv2.entity.Character;

public interface CharacterRepository {
    boolean create(Character character);
    boolean update(Long id, Character anime);
    boolean delete(Long id);
}
