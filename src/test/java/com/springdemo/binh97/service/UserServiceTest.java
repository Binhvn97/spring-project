package com.springdemo.binh97.service;

import com.springdemo.binh97.dto.request.UserCreateRequest;
import com.springdemo.binh97.dto.response.UserResponse;
import com.springdemo.binh97.entities.User;
import com.springdemo.binh97.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.time.LocalDate;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @MockitoBean
    private UserRepository userRepository;

    private User user;
    private UserCreateRequest userCreateRequest;
    private UserResponse userResponse;


    @BeforeEach
    public void initData() {
        LocalDate dob = LocalDate.of(1997, 9, 20);
        userCreateRequest = UserCreateRequest.builder()
                .username("binh97")
                .password("@Abc123123")
                .firstName("Binh")
                .lastName("Hoang")
                .email("binh97@gmail.com")
                .dob(dob)
                .build();

        userResponse = UserResponse.builder()
                .id("09a88faD9ds26")
                .username("binh97")
                .firstName("Binh")
                .lastName("Hoang")
                .email("binh97@gmail.com")
                .dob(dob)
                .build();

        user = User.builder()
                .id("09a88faD9ds26")
                .username("binh97")
                .firstName("Binh")
                .lastName("Hoang")
                .email("binh97@gmail.com")
                .dob(dob)
                .build();
    }

    @Test
    void createUser_validRequest_success() {
        // GIVEN
        Mockito.when(userRepository.existsByUsername(anyString())).thenReturn(false);
        Mockito.when(userRepository.save(any())).thenReturn(user);

        // WHEN
        var response = userService.createUser(userCreateRequest);

        // THEN
        Assertions.assertThat(response.getId()).isEqualTo("09a88faD9ds26");
        Assertions.assertThat(response.getUsername()).isEqualTo("binh97");
    }



}
