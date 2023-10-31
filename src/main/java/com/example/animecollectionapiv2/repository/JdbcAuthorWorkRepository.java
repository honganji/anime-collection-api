package com.example.animecollectionapiv2.repository;

import com.example.animecollectionapiv2.entity.Author;
import com.example.animecollectionapiv2.entity.AuthorWork;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcAuthorWorkRepository implements AuthorWorkRepository{
    private final JdbcTemplate jdbcTemplate;
    public JdbcAuthorWorkRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public boolean create(AuthorWork authorWork) {
        System.out.println(authorWork.getAuthorId());
        int count = jdbcTemplate.update(
                "INSERT INTO author_works (author_id, name) VALUES(?, ?)",
                authorWork.getAuthorId(),
                authorWork.getName()
        );
        return count != 0;
    }

    @Override
    public AuthorWork selectById(Long id) {
        return jdbcTemplate.queryForObject(
                "SELECT * FROM author_works WHERE author_id=?",
                new DataClassRowMapper<>(AuthorWork.class),
                id
        );
    }

    @Override
    public boolean update(Long id, AuthorWork authorWork) {
        int count = jdbcTemplate.update(
                "UPDATE author_works SET author_id=?, name=?",
                authorWork.getAuthorId(),
                authorWork.getName(),
                id
        );
        return count != 0;
    }

    @Override
    public boolean delete(Long id) {
        int count = jdbcTemplate.update("DELETE FROM author_works WHERE id=?", id);
        return count != 0;
    }
}
