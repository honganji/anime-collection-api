package com.example.animecollectionapiv2.repository;

import com.example.animecollectionapiv2.entity.User;
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
    public User selectByEmailAddress(String emailAddress) {
        String sql = "SELECT * FROM users WHERE email_address=?";
        User data;
        try{
            data = jdbcTemplate.queryForObject(
                    sql,
                    new DataClassRowMapper<>(User.class),
                    emailAddress
            );
        } catch (EmptyResultDataAccessException e){
            return null;
        }
        return data;
    }

    @Override
    public boolean create(User user) {
        String sql = "INSERT INTO users (name, email_address, password) VALUES(?, ?, ?)";
        int count = jdbcTemplate.update(
                sql,
                user.getName(),
                user.getEmailAddress(),
                user.getPassword()
        );
        return count != 0;
    }
}
