package com.example.animecollectionapiv2.repository;

import com.example.animecollectionapiv2.entity.Comment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Repository
public class JdbcCommentRepository implements CommentRepository{
    private final JdbcTemplate jdbcTemplate;
    public JdbcCommentRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public boolean create(Comment newComment) {
        LocalDateTime nowDate = LocalDateTime.now();
        int count = jdbcTemplate.update(
                "INSERT INTO comments (anime_id, user_id, content, created_time) VALUES(?, ?, ?, ?)",
                newComment.getAnimeId(),
                newComment.getUserId(),
                newComment.getContent(),
                nowDate
        );
        return count != 0;
    }

    @Override
    public List<Map<String, Object>> selectById(Long id) {
        List<Map<String, Object>> json = null;
        String sql = "SELECT anime_id, user_id, content " +
                "FROM comments " +
                "WHERE anime_id=? " +
                "ORDER BY created_time desc " +
                "LIMIT 15";
        json = jdbcTemplate.queryForList(sql, id);
        return json;
    }

    @Override
    public boolean update(Long id, Comment newComment) {
        LocalDateTime nowDate = LocalDateTime.now();
        int count = jdbcTemplate.update(
                "UPDATE comments SET anime_id=?, user_id=?, content=? WHERE id=?",
                newComment.getAnimeId(),
                newComment.getUserId(),
                newComment.getContent(),
                id
        );
        return count != 0;
    }

    @Override
    public boolean delete(Long id) {
        int count = jdbcTemplate.update("DELETE FROM comments WHERE id=?", id);
        return count != 0;
    }
}
