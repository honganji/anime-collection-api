package com.example.animecollectionapiv2.controller;

import com.example.animecollectionapiv2.entity.Character;
import com.example.animecollectionapiv2.service.CharacterService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/characters")
public class CharacterController {
    private final CharacterService characterService;
    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }

    @PostMapping
    public String create(@RequestBody Character newCharacter) {
        boolean isSucceed = characterService.create(newCharacter);
        return isSucceed ? "The creation is done successfully!" : "The creation is failed";
    }

    @PutMapping("/{id}")
    public String update(@PathVariable Long id, @RequestBody Character newCharacter) {
        boolean isSucceed = characterService.update(id, newCharacter);
        return isSucceed ? "The update is done successfully!" : "The update is failed";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        boolean isSucceed = characterService.delete(id);
        return isSucceed ? "The deletion is done successfully!" : "The deletion is failed";
    }
}
