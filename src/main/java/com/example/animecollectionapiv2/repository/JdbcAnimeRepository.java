package com.example.animecollectionapiv2.repository;

import com.example.animecollectionapiv2.entity.Anime;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Repository
public class JdbcAnimeRepository implements AnimeRepository{
    private final JdbcTemplate jdbcTemplate;
    public JdbcAnimeRepository(JdbcTemplate jdbcTemplate) { this.jdbcTemplate = jdbcTemplate; }

    @Override
    public boolean create(Anime anime) {
        int count = jdbcTemplate.update(
                "INSERT INTO animes (author_id, genre_id, name, thumbnail_url, trailer_id, mad_id, episode, series, description, story, started_date) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                anime.getAuthorId(),
                anime.getGenreId(),
                anime.getName(),
                anime.getThumbnailUrl(),
                anime.getTrailerId(),
                anime.getMadId(),
                anime.getEpisode(),
                anime.getSeries(),
                anime.getDescription(),
                anime.getStory(),
                anime.getStartedDate()
        );
        return count != 0;
    }

    @Override
    public Anime selectById(Long id) {
        return jdbcTemplate.queryForObject(
                "SELECT * FROM animes WHERE id=?",
                new DataClassRowMapper<>(Anime.class),
                id
        );
    }

    @Override
    public List<Anime> selectAll() {
        return jdbcTemplate.query(
                "SELECT * FROM animes",
                new DataClassRowMapper<>(Anime.class)
        );
    }

    @Override
    public boolean update(Long id, Anime anime) {
        int count = jdbcTemplate.update(
                "UPDATE animes SET author_id=?, genre_id=?, name=?, thumbnail_url=?, trailer_id=?, mad_id=?, episode=?, series=?, description=?, story=?, started_date=? WHERE id=?",
                anime.getAuthorId(),
                anime.getGenreId(),
                anime.getName(),
                anime.getThumbnailUrl(),
                anime.getTrailerId(),
                anime.getMadId(),
                anime.getEpisode(),
                anime.getSeries(),
                anime.getDescription(),
                anime.getStory(),
                anime.getStartedDate(),
                id
        );
        return count != 0;
    }

    @Override
    public boolean delete(Long id) {
        int count = jdbcTemplate.update("DELETE FROM animes WHERE id=?", id);
        return count != 0;
    }
}
