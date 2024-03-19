package com.example.Fitenssobacked.mapper;

import com.example.Fitenssobacked.dtos.SignUpDto;
import com.example.Fitenssobacked.dtos.UserDto;
import com.example.Fitenssobacked.model.User;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import org.mapstruct.Mapper;


import java.util.List;


@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toUserDto(User user);

    List<UserDto> toUserDtoList(List<User> users);

    @Mapping(target = "password", ignore = true)
    User signUpToUser(SignUpDto signUpDto);


}
