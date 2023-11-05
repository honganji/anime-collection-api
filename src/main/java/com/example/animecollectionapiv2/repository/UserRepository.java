package com.example.animecollectionapiv2.repository;

import com.example.animecollectionapiv2.entity.User;

import java.util.Optional;

public interface UserRepository {
    User selectByLogin(String login);
}
