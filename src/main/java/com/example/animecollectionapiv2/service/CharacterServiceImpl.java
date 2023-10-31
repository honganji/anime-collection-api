package com.example.animecollectionapiv2.service;

import com.example.animecollectionapiv2.entity.Character;
import com.example.animecollectionapiv2.repository.CharacterRepository;
import org.springframework.stereotype.Service;

@Service
public class CharacterServiceImpl implements CharacterService{
    private final CharacterRepository characterRepository;
    public CharacterServiceImpl(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    @Override
    public boolean create(Character newCharacter) { return characterRepository.create(newCharacter); }

    @Override
    public boolean update(Long id, Character newCharacter) {
        return characterRepository.update(id, newCharacter);
    }

    @Override
    public boolean delete(Long id) {
        return characterRepository.delete(id);
    }
}
