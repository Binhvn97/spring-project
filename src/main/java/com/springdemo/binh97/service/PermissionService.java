package com.springdemo.binh97.service;

import com.springdemo.binh97.dto.request.PermissionRequest;
import com.springdemo.binh97.dto.response.PermissionResponse;
import com.springdemo.binh97.entities.Permission;
import com.springdemo.binh97.mapper.PermissionMapper;
import com.springdemo.binh97.repository.PermissionRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PermissionService {
    PermissionRepository permissionRepository;
    PermissionMapper permissionMapper;

    public PermissionResponse create(PermissionRequest request) {
        Permission permission = permissionMapper.toPermission(request);
        permission = permissionRepository.save(permission);
        return permissionMapper.toPermissionResponse(permission);
    }

    public List<PermissionResponse> findAll() {
        List<Permission> permissions = permissionRepository.findAll();
        return permissions.stream().map(permissionMapper::toPermissionResponse).collect(Collectors.toList());
    }

    public void delete(String permissionName) {
        permissionRepository.deleteById(permissionName);
    }


}
