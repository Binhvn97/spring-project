package com.springdemo.binh97.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RoleRequest {

    @NotBlank(message = "USER_INVALID")
    String name;
    String description;

    Set<String> permissions;
}
