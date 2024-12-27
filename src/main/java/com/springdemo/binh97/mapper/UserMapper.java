package com.springdemo.binh97.mapper;

import com.springdemo.binh97.dto.request.UserCreateRequest;
import com.springdemo.binh97.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserCreateRequest request);
}
