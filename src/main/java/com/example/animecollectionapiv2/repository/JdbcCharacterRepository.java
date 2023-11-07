package com.example.animecollectionapiv2.repository;

import com.example.animecollectionapiv2.entity.Character;
import com.example.animecollectionapiv2.entity.Genre;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class JdbcCharacterRepository implements CharacterRepository{
    private final JdbcTemplate jdbcTemplate;
    JdbcCharacterRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public boolean create(Character newCharacter) {
        int count = jdbcTemplate.update(
                "INSERT INTO characters (anime_id, voice_actor_id, img_url, feature, name) VALUES(?, ?, ?, ?, ?)",
                newCharacter.getAnimeId(),
                newCharacter.getVoiceActorId(),
                newCharacter.getImgUrl(),
                newCharacter.getFeature(),
                newCharacter.getName()
        );
        return count != 0;
    }

    @Override
    public List<Map<String, Object>> getByAnimeId(Long animeId) {
        String sql = "SELECT name, img_url, feature FROM characters WHERE anime_id=?";
        return jdbcTemplate.queryForList(sql, animeId);
    }

    @Override
    public boolean update(Long id, Character newCharacter) {
        int count = jdbcTemplate.update(
                "UPDATE characters SET anime_id=?, voice_actor_id=?, img_url=?, feature=?, name=? WHERE id=?",
                newCharacter.getAnimeId(),
                newCharacter.getVoiceActorId(),
                newCharacter.getImgUrl(),
                newCharacter.getFeature(),
                newCharacter.getName(),
                id
        );
        return count != 0;
    }

    @Override
    public boolean delete(Long id) {
        int count = jdbcTemplate.update("DELETE FROM characters WHERE id=?", id);
        return count != 0;
    }
}
