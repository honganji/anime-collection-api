package com.example.animecollectionapiv2.service;

import com.example.animecollectionapiv2.dto.CredentialsDto;
import com.example.animecollectionapiv2.dto.SignUpDto;
import com.example.animecollectionapiv2.dto.UserDto;

public interface UserService {
    UserDto findByEmailAddress(String emailAddress);
    UserDto login(CredentialsDto credentialsDto);
    UserDto signup(SignUpDto signUpDto);
}
