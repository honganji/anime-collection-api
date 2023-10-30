package com.example.animecollectionapiv2.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "author_works")
public class AuthorWork {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
}
