package com.springdemo.binh97.dto.request;

import com.springdemo.binh97.validator.ValidPassword;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserCreateRequest {

    @NotBlank(message = "USER_INVALID")
    @Size(min = 3, message = "USER_INVALID")
    String username;

    @NotBlank(message = "PASSWORD_INVALID")
    @Size(min = 8, message = "PASSWORD_INVALID")
    @ValidPassword(message = "PASSWORD_INVALID")
    String password;
    String email;
    String firstName;
    String lastName;
    LocalDate dob;

}
