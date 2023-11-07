package com.example.animecollectionapiv2.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "characters")
public class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "anime_id", nullable = false)
    private Long animeId;

    @Column(name = "voice_actor_id", nullable = false)
    private Long voiceActorId;

    @Column(columnDefinition = "LONGTEXT", name = "img_url", nullable = false)
    private String imgUrl;

    @Column(columnDefinition = "LONGTEXT", nullable = false)
    private String feature;

    @Column(name = "name", nullable = false)
    private String name;

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

    public Long getVoiceActorId() {
        return voiceActorId;
    }

    public void setVoiceActorId(Long voiceActorId) {
        this.voiceActorId = voiceActorId;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
