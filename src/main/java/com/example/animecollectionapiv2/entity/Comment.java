package com.example.animecollectionapiv2.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "anime_id", nullable = false)
    private Long animeId;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(columnDefinition = "LONGTEXT", nullable = false)
    private String content;

    @Column(name = "created_time", nullable = false)
    private Date createdTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAnimeId() {
        return animeId;
    }

    public void setAnimeId(Long animeId) {
        this.animeId = animeId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
