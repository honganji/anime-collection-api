package com.example.animecollectionapiv2.mapper;

import com.example.animecollectionapiv2.dto.SignUpDto;
import com.example.animecollectionapiv2.dto.UserDto;
import com.example.animecollectionapiv2.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toUserDto(User user);

    @Mapping(target = "password")
    User signUpToUser(SignUpDto userDto);
}
