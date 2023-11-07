package com.example.animecollectionapiv2.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "animes")
public class Anime {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "author_id", nullable = false)
    private Long authorId;
    @Column(name = "genre_id", nullable = false)
    private Long genreId;
    @Column(nullable = false)
    private String name;
    @Column(columnDefinition = "LONGTEXT", name = "thumbnail_url", nullable = false)
    private String thumbnailUrl;
    @Column(name = "trailer_id", nullable = false)
    private String trailerId;
    @Column(name = "mad_id", nullable = false)
    private String madId;
    @Column(nullable = false)
    private Integer episode;
    @Column(nullable = false)
    private Integer series;
    @Column(columnDefinition = "LONGTEXT", nullable = false)
    private String description;
    @Column(columnDefinition = "LONGTEXT", nullable = false)
    private String story;
    @Column(columnDefinition = "DATETIME", name = "started_date", nullable = false)
    private Date startedDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public Long getGenreId() {
        return genreId;
    }

    public void setGenreId(Long genreId) {
        this.genreId = genreId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public String getTrailerId() {
        return trailerId;
    }

    public void setTrailerId(String trailerId) {
        this.trailerId = trailerId;
    }

    public String getMadId() {
        return madId;
    }

    public void setMadId(String madId) {
        this.madId = madId;
    }

    public Integer getEpisode() {
        return episode;
    }

    public void setEpisode(Integer episode) {
        this.episode = episode;
    }

    public Integer getSeries() {
        return series;
    }

    public void setSeries(Integer series) {
        this.series = series;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }

    public Date getStartedDate() {
        return startedDate;
    }

    public void setStartedDate(Date startedDate) {
        this.startedDate = startedDate;
    }
}
