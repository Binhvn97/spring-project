package com.springdemo.binh97.controller;

import com.springdemo.binh97.dto.request.RoleRequest;
import com.springdemo.binh97.dto.response.ApiResponse;
import com.springdemo.binh97.dto.response.RoleResponse;
import com.springdemo.binh97.service.RoleService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class RoleController {

    RoleService roleService;

    @PostMapping
    ApiResponse<RoleResponse> create(@RequestBody @Valid RoleRequest request) {
        return ApiResponse.<RoleResponse>builder()
                .code(200)
                .message("Created Permission Successfully")
                .result(roleService.createRole(request))
                .build();
    }

    @GetMapping
    ApiResponse<List<RoleResponse>> getAll() {
        return ApiResponse.<List<RoleResponse>>builder()
                .code(200)
                .result(roleService.findAllRoles())
                .build();
    }

    @DeleteMapping("/{role}")
    ApiResponse<Void> delete(@PathVariable String role) {
        roleService.deleteRole(role);
        return ApiResponse.<Void>builder()
                .message("Deleted Role Successfully")
                .code(200)
                .build();
    }

}
