package com.example.animecollectionapiv2.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Anime {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "author_id")
    private Long authorId;
    @Column(name = "genre_id")
    private Long genreId;
    @Column(name = "name")
    private String name;
    @Column(columnDefinition = "LONGTEXT", name = "thumbnail_url")
    private String thumbnailUrl;
    @Column(name = "trailer_id")
    private String trailerId;
    @Column(name = "mad_id")
    private String madId;
    @Column(name = "episode")
    private Integer episode;
    @Column(name = "series")
    private Integer series;
    @Column(columnDefinition = "LONGTEXT",name = "description")
    private String description;
    @Column(columnDefinition = "LONGTEXT",name = "story")
    private String story;
    @Column(columnDefinition = "DATETIME",name = "started_date")
    private Date startedDate;
}
