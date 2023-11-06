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

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDto findByEmailAddress(String emailAddress) {
        User user = userRepository.selectByEmailAddress(emailAddress);
        if(user == null) {
            throw new AppException("Unknown user", HttpStatus.NOT_FOUND);
        }
        return userMapper.toUserDto(user);
    }

    @Override
    public UserDto login(CredentialsDto credentialsDto) {
        User user = userRepository.selectByEmailAddress(credentialsDto.getEmailAddress());
        if(user == null) {
            throw new AppException("Unknown user", HttpStatus.NOT_FOUND);
        }

        if(passwordEncoder.matches(CharBuffer.wrap(credentialsDto.getPassword()), user.getPassword())) {
            return userMapper.toUserDto(user);
        };

        throw new AppException("Invalid password", HttpStatus.BAD_REQUEST);
    }

    @Override
    public UserDto signup(SignUpDto userDto) {

        User optionalUser = userRepository.selectByEmailAddress(userDto.getEmailAddress());

        if(optionalUser != null) {
            throw new AppException("Login already exists", HttpStatus.BAD_REQUEST);
        }

        User user = userMapper.signUpToUser(userDto);

        user.setPassword(passwordEncoder.encode(CharBuffer.wrap(userDto.getPassword())));

        userRepository.create(user);

        User dbUser = userRepository.selectByEmailAddress(user.getEmailAddress());

        user.setId(dbUser.getId());

        return userMapper.toUserDto(user);
    }
}
