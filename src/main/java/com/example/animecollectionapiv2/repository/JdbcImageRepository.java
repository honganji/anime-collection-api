package com.example.animecollectionapiv2.repository;

import com.example.animecollectionapiv2.entity.Genre;
import com.example.animecollectionapiv2.entity.Image;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class JdbcImageRepository implements ImageRepository{
    private final JdbcTemplate jdbcTemplate;
    JdbcImageRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public boolean create(Image newImage) {
        int count = jdbcTemplate.update(
                "INSERT INTO images (anime_id, url) VALUES(?, ?)",
                newImage.getAnimeId(),
                newImage.getUrl()
        );
        return count != 0;
    }

    @Override
    public List<Map<String, Object>> getNameByAnimeId(Long animeId) {
        String sql = "SELECT url FROM images WHERE anime_id=?";
        return jdbcTemplate.queryForList(sql, animeId);
    }

    @Override
    public boolean update(Long id, Image newImage) {
        int count = jdbcTemplate.update(
                "UPDATE images SET anime_id=?, url=? WHERE id=?",
                newImage.getAnimeId(),
                newImage.getUrl(),
                id
        );
        return count != 0;
    }

    @Override
    public boolean delete(Long id) {
        int count = jdbcTemplate.update("DELETE FROM images WHERE id=?", id);
        return count != 0;
    }
}
