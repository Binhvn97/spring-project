package com.springdemo.binh97.controller;

import com.springdemo.binh97.dto.response.ApiResponse;
import com.springdemo.binh97.dto.request.UserCreateRequest;
import com.springdemo.binh97.dto.request.UserUpdateRequest;
import com.springdemo.binh97.dto.response.UserResponse;
import com.springdemo.binh97.service.UserService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class UserController {

    UserService userService;

    @PostMapping
    ApiResponse<UserResponse> createUser(@RequestBody @Valid UserCreateRequest request) {
        ApiResponse<UserResponse> apiResponse = new ApiResponse<>();
        apiResponse.setResult(userService.createUser(request));
        apiResponse.setMessage("Created successfully");
        apiResponse.setCode(200);
        return apiResponse;
    }

    @GetMapping
    ApiResponse<List<UserResponse>> getUsers() {
        return ApiResponse.<List<UserResponse>>builder()
                .result(userService.getUsers())
                .build();
    }

    @GetMapping("/{id}")
    UserResponse getUser(@PathVariable("id") String userId) {
        return userService.getUser(userId);
    }

    @PutMapping("/{id}")
    UserResponse updateUser(@PathVariable String id, @RequestBody @Valid UserUpdateRequest request) {
        return userService.updateUser(id, request);
    }

    @DeleteMapping("/{id}")
    String deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
        return "Deleted successfully";
    }
}
