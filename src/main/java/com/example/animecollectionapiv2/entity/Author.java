package com.example.animecollectionapiv2.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(columnDefinition = "BIGINT", name = "anime_id")
    private String anime_id;
    private String name;
    @Column(columnDefinition = "LONGTEXT", name="img_url")
    private String img_url;
}
