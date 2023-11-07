package com.example.animecollectionapiv2.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Size(max = 20)
    private String name;

    @Column(name = "email_address", nullable = false)
    @Size(max = 20)
    private String emailAddress;

    @Column(nullable = false)
    @Size(max = 20, min = 4)
    private String password;
}
