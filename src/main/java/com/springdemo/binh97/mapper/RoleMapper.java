package com.springdemo.binh97.mapper;

import com.springdemo.binh97.dto.request.RoleRequest;
import com.springdemo.binh97.dto.response.RoleResponse;
import com.springdemo.binh97.entities.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface RoleMapper {

    @Mapping(target = "permissions", ignore = true)
    Role toRole (RoleRequest request);

    RoleResponse toRoleResponse (Role role);
}
