package com.example.animecollectionapiv2.repository;

import com.example.animecollectionapiv2.entity.Genre;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class JdbcGenreRepository implements GenreRepository{
    private final JdbcTemplate jdbcTemplate;
    JdbcGenreRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public boolean create(Genre newGenre) {
        int count = jdbcTemplate.update(
                "INSERT INTO genres (name) VALUES(?)",
                newGenre.getName()
        );
        return count != 0;
    }

    @Override
    public boolean update(Long id, Genre newGenre) {
        int count = jdbcTemplate.update(
                "UPDATE genres SET name=? WHERE id=?",
                newGenre.getName(),
                id
        );
        return count != 0;
    }

    @Override
    public boolean delete(Long id) {
        int count = jdbcTemplate.update("DELETE FROM genres WHERE id=?", id);
        return count != 0;
    }
}
