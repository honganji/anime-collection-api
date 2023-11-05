package com.example.animecollectionapiv2.repository;

import com.example.animecollectionapiv2.entity.User;
import com.example.animecollectionapiv2.service.UserService;
import org.springframework.dao.EmptyResultDataAccessException;
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
        User data;
        try{
            data = jdbcTemplate.queryForObject(
                    sql,
                    new DataClassRowMapper<>(User.class),
                    login
            );
        } catch (EmptyResultDataAccessException e){
            return null;
        }
        return data;
    }

    @Override
    public boolean create(User user) {
        String sql = "";
        int count = jdbcTemplate.update(
                "INSERT INTO users (first_name, last_name, login, password) VALUES(?, ?, ?, ?)",
                user.getFirstName(),
                user.getLastName(),
                user.getLogin(),
                user.getPassword()
        );
        return count != 0;
    }
}
