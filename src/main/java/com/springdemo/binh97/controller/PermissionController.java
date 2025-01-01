package com.springdemo.binh97.controller;

import com.springdemo.binh97.dto.request.PermissionRequest;
import com.springdemo.binh97.dto.response.ApiResponse;
import com.springdemo.binh97.dto.response.PermissionResponse;
import com.springdemo.binh97.service.PermissionService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/permissions")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class PermissionController {

    PermissionService permissionService;

    @PostMapping
    ApiResponse<PermissionResponse> create(@RequestBody @Valid PermissionRequest request) {
        return ApiResponse.<PermissionResponse>builder()
                .code(200)
                .message("Created Permission Successfully")
                .result(permissionService.create(request))
                .build();
    }

    @GetMapping
    ApiResponse<List<PermissionResponse>> getAll() {
        return ApiResponse.<List<PermissionResponse>>builder()
                .code(200)
                .result(permissionService.findAll())
                .build();
    }

    @DeleteMapping("/{permission}")
    ApiResponse<Void> delete(@PathVariable String permission) {
        permissionService.delete(permission);
        return ApiResponse.<Void>builder()
                .message("Deleted Permission Successfully")
                .code(200)
                .build();
    }

}
