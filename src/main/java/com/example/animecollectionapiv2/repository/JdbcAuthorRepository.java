package com.example.animecollectionapiv2.repository;

import com.example.animecollectionapiv2.entity.Author;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JdbcAuthorRepository implements  AuthorRepository{
    private final JdbcTemplate jdbcTemplate;
    public JdbcAuthorRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public boolean create(Author author) {
        int count = jdbcTemplate.update(
                "INSERT INTO authors (name, img_url) VALUES(?, ?)",
                author.getName(),
                author.getImg_url()
        );
        return count != 0;
    }

    @Override
    public Author selectById(Long id) {
        return jdbcTemplate.queryForObject(
                "SELECT * FROM authors WHERE id=?",
                new DataClassRowMapper<>(Author.class),
                id
        );
    }

    @Override
    public boolean update(Long id, Author author) {
        int count = jdbcTemplate.update(
                "UPDATE authors SET name=?, img_url=?",
                author.getName(),
                author.getImg_url()
        );
        return count != 0;
    }

    @Override
    public boolean delete(Long id) {
        int count = jdbcTemplate.update("DELETE FROM authors WHERE id=?", id);
        return count != 0;
    }
}
