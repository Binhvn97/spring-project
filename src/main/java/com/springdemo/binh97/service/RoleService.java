package com.springdemo.binh97.service;

import com.springdemo.binh97.dto.request.RoleRequest;
import com.springdemo.binh97.dto.response.RoleResponse;
import com.springdemo.binh97.mapper.RoleMapper;
import com.springdemo.binh97.repository.PermissionRepository;
import com.springdemo.binh97.repository.RoleRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RoleService {
    RoleRepository roleRepository;
    PermissionRepository permissionRepository;
    RoleMapper roleMapper;

    public RoleResponse createRole(RoleRequest request) {
        var role = roleMapper.toRole(request);

        var permissions = permissionRepository.findAllById(request.getPermissions());
        role.setPermissions(new HashSet<>(permissions));

        role = roleRepository.save(role);
        return roleMapper.toRoleResponse(role);
    }

    public List<RoleResponse> findAllRoles() {
        return roleRepository.findAll()
                .stream()
                .map(roleMapper::toRoleResponse)
                .toList() ;
    }

    public void deleteRole(String roleId) {
        roleRepository.deleteById(roleId);
    }
}
