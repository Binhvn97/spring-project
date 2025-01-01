package com.springdemo.binh97.dto.request;

import com.springdemo.binh97.validator.dob.ValidDob;
import com.springdemo.binh97.validator.password.ValidPassword;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserUpdateRequest {

    @NotBlank(message = "PASSWORD_INVALID")
    @Size(min = 8, message = "PASSWORD_INVALID")
    @ValidPassword(message = "PASSWORD_INVALID")
    String password;
    String email;
    String firstName;
    String lastName;

    @ValidDob(min = 10, message = "INVALID_DOB")
    LocalDate dob;

    List<String> roles;

}
