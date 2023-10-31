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
        List<Map<String, Object>> json = null;
        List<Map<String, Object>> authorWorkJson = null;
        List<String> authorWorkList = new ArrayList<String>();
        List<Map<String, Object>> imageJson = null;
        List<String> imageList = new ArrayList<String>();
        List<Map<String, Object>> characterJson = null;
        List<Map<String, Object>> characterList = new ArrayList<Map<String, Object>>();

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
                "animes.genre_id as 'genre', " +
                "animes.started_date as 'started_date', " +
                "animes.id as 'images', " +
                "animes.id as 'characters', " +
                "animes.author_id " +
                "FROM animes " +
                "JOIN authors ON animes.author_id = authors.id " +
                "JOIN author_works ON authors.id = author_works.author_id " +
                "AND animes.id=?";
        String authorWorkSql = "SELECT name FROM author_works WHERE author_id=?";
        String imageSql = "SELECT url FROM images WHERE anime_id=?";
        String characterSql = "SELECT name, img_url, feature FROM characters WHERE anime_id=?";

        json = jdbcTemplate.queryForList(sql, id);
        authorWorkJson = jdbcTemplate.queryForList(authorWorkSql, json.get(0).get("author_id"));
        imageJson = jdbcTemplate.queryForList(imageSql, id);
        characterJson = jdbcTemplate.queryForList(characterSql, id);

        authorWorkJson.forEach(element -> authorWorkList.add((String) element.get("name")));
        imageJson.forEach(element -> imageList.add((String) element.get("url")));
        characterJson.forEach(element -> characterList.add(element));

        json.get(0).put("author_work", authorWorkList);
        json.get(0).put("images", imageList);
        json.get(0).put("characters", characterList);
        return json;
    }

    @Override
    public List<Map<String, Object>> selectAll() {
        List<Map<String, Object>> json = null;
        final String sql = "SELECT " +
                "animes.id as 'anime_id', " +
                "animes.name as 'name', " +
                "animes.thumbnail_url as 'image_url', " +
                "animes.trailer_id as 'trailer_id', " +
                "animes.mad_id as 'mad_id', " +
                "authors.name as 'author', " +
                "authors.img_url as 'author_img', " +
                "animes.author_id as 'author_work(not yet)', " +
                "animes.episode as 'episodes', " +
                "animes.series as 'serises', " +
                "animes.description as 'description', " +
                "animes.story as 'story', " +
                "animes.genre_id as 'genre(not yet)', " +
                "animes.started_date as 'started_date', " +
                "animes.id as 'images(Not yet)', " +
                "animes.id as 'characters(Not yet)' " +
                "FROM animes JOIN authors ON animes.author_id = authors.id";
        json = jdbcTemplate.queryForList(sql);
        return json;
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
