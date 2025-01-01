package com.springdemo.binh97.mapper;

import com.springdemo.binh97.dto.request.PermissionRequest;
import com.springdemo.binh97.dto.response.PermissionResponse;
import com.springdemo.binh97.entities.Permission;
import org.mapstruct.Mapper;

@Mapper
public interface PermissionMapper {
    Permission toPermission (PermissionRequest request);
    PermissionResponse toPermissionResponse (Permission permission);
}
