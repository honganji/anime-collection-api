package com.example.animecollectionapiv2.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "images")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "anime_id", nullable = false)
    private Long animeId;

    @Column(columnDefinition = "LONGTEXT", nullable = false)
    private String url;

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
