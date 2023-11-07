package com.example.animecollectionapiv2.repository;

import com.example.animecollectionapiv2.entity.Anime;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
    public List<Map<String, Object>> selectById(Long id) {
        String sql = "SELECT " +
                "animes.id as 'anime_id', " +
                "animes.name as 'name', " +
                "animes.thumbnail_url as 'image_url', " +
                "animes.trailer_id as 'trailer_id', " +
                "animes.mad_id as 'mad_id', " +
                "authors.name as 'author', " +
                "authors.img_url as 'author_img', " +
                "author_works.name as 'author_work', " +
                "animes.episode as 'episodes', " +
                "animes.series as 'series', " +
                "animes.description as 'description', " +
                "animes.story as 'story', " +
                "genres.name as 'genre', " +
                "animes.started_date as 'started_date', " +
                "animes.id as 'images', " +
                "animes.id as 'characters', " +
                "animes.author_id " +
                "FROM animes " +
                "JOIN authors ON animes.author_id = authors.id " +
                "JOIN author_works ON authors.id = author_works.author_id " +
                "JOIN genres ON genres.id = animes.genre_id " +
                "AND animes.id=?";
        return jdbcTemplate.queryForList(sql, id);
    }

    @Override
    public List<Map<String, Object>> selectAll() {
        List<Long> idList = new ArrayList<Long>();
        List<Map<String, Object>> idJson = null;
        List<Map<String, Object>> json = new ArrayList<>();
        final String idSql = "SELECT id FROM animes";
        idJson = jdbcTemplate.queryForList(idSql);
        idJson.forEach(element -> idList.add((Long) element.get("id")));
        idList.forEach(id ->{
            json.add(selectById(id).get(0));
        });
        return json;
    }

    @Override
    public List<Map<String, Object>> getAllId() {
        final String sql = "SELECT id FROM animes";
        return jdbcTemplate.queryForList(sql);
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
