package com.example.animecollectionapiv2.repository;

import com.example.animecollectionapiv2.entity.User;
import com.example.animecollectionapiv2.service.UserService;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcUserRepository implements UserRepository {
    private final JdbcTemplate jdbcTemplate;
    public JdbcUserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public User selectByLogin(String login) {
        String sql = "SELECT * FROM users WHERE login=?";
        return jdbcTemplate.queryForObject(
                sql,
                new DataClassRowMapper<>(User.class),
                login
        );
    }
}
