package com.example.animecollectionapiv2.service;

import com.example.animecollectionapiv2.dto.CredentialsDto;
import com.example.animecollectionapiv2.dto.SignUpDto;
import com.example.animecollectionapiv2.dto.UserDto;
import com.example.animecollectionapiv2.entity.User;
import com.example.animecollectionapiv2.exception.AppException;
import com.example.animecollectionapiv2.mapper.UserMapper;
import com.example.animecollectionapiv2.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.CharBuffer;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    public UserDto findByLogin(String login) {
        User user = userRepository.selectByLogin(login);
        if(user == null) {
            throw new AppException("Unknown user", HttpStatus.NOT_FOUND);
        }
        return userMapper.toUserDto(user);
    }

    public UserDto login(CredentialsDto credentialsDto) {
        User user = userRepository.selectByLogin(credentialsDto.getLogin());
        if(user == null) {
            throw new AppException("Unknown user", HttpStatus.NOT_FOUND);
        }

        if(passwordEncoder.matches(CharBuffer.wrap(credentialsDto.getPassword()), user.getPassword())) {
            return userMapper.toUserDto(user);
        };

        throw new AppException("Invalid password", HttpStatus.BAD_REQUEST);
    }

    public UserDto register(SignUpDto userDto) {

        User optionalUser = userRepository.selectByLogin(userDto.getLogin());

        if(optionalUser != null) {
            throw new AppException("Login already exists", HttpStatus.BAD_REQUEST);
        }

        User user = userMapper.signUpToUser(userDto);

        user.setPassword(passwordEncoder.encode(CharBuffer.wrap(userDto.getPassword())));

        userRepository.create(user);

        return userMapper.toUserDto(user);
    }
}
