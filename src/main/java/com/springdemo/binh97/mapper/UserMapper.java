package com.springdemo.binh97.mapper;

import com.springdemo.binh97.dto.request.UserCreateRequest;
import com.springdemo.binh97.dto.request.UserUpdateRequest;
import com.springdemo.binh97.dto.response.UserResponse;
import com.springdemo.binh97.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserCreateRequest request);
    UserResponse toUserResponse(User user);

    void updateUser(@MappingTarget User user, UserUpdateRequest request);
}
