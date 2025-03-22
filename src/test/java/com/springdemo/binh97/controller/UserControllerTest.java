package com.springdemo.binh97.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.springdemo.binh97.dto.request.UserCreateRequest;
import com.springdemo.binh97.dto.response.UserResponse;
import com.springdemo.binh97.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;

@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource("/test.properties")
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private UserService userService;

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
    }


    @Test
    void createUser_validRequest_success() throws Exception {
        // Given
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        String content = objectMapper.writeValueAsString(userCreateRequest);

        Mockito.when(userService.createUser(ArgumentMatchers.any())).thenReturn(userResponse);

        // When -> Then
        mockMvc.perform(MockMvcRequestBuilders
                .post("/users")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(content))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("code").value(200))
                .andExpect(MockMvcResultMatchers.jsonPath("result.id").value("09a88faD9ds26"))
                .andExpect(MockMvcResultMatchers.jsonPath("result.username").value("binh97"))
                .andExpect(MockMvcResultMatchers.jsonPath("result.email").value("binh97@gmail.com"))
                .andExpect(MockMvcResultMatchers.jsonPath("result.firstName").value("Binh"))
                .andExpect(MockMvcResultMatchers.jsonPath("result.lastName").value("Hoang"))
                .andExpect(MockMvcResultMatchers.jsonPath("result.dob").value("1997-09-20"));
    }

    @Test
    void createUser_invalidUsername_fail() throws Exception {
        // Given
        userCreateRequest.setUsername("abc");
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        String content = objectMapper.writeValueAsString(userCreateRequest);

        // When -> Then
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/users")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(content))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("code").value(400))
                .andExpect(MockMvcResultMatchers.jsonPath("message")
                        .value("Username must be at least 3 characters long and cannot be blank."));
    }

    @Test
    void createUser_blankUsername_fail() throws Exception {

        userCreateRequest.setUsername("");
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        String content = objectMapper.writeValueAsString(userCreateRequest);

        mockMvc.perform(MockMvcRequestBuilders
                .post("/users")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(content))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("code").value(400))
                .andExpect(MockMvcResultMatchers.jsonPath("message")
                .value("Username must be at least 3 characters long and cannot be blank."));
    }

    @Test
    void createUser_invalidPassword_fail() throws Exception {
        userCreateRequest.setPassword("abc123");
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        String content = objectMapper.writeValueAsString(userCreateRequest);

        mockMvc.perform(MockMvcRequestBuilders
        .post("/users")
        .contentType(MediaType.APPLICATION_JSON_VALUE)
        .content(content))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("code").value(400))
                .andExpect(MockMvcResultMatchers.jsonPath("message")
                .value("Password must be at least 8 characters long, cannot be blank, and must contain at least one uppercase letter and one special character."));
    }

    @Test
    void createUser_invalidDob_fail() throws Exception {
        userCreateRequest.setDob(LocalDate.parse("2022-02-03"));
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        String content = objectMapper.writeValueAsString(userCreateRequest);

        mockMvc.perform(MockMvcRequestBuilders
                .post("/users")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(content))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("code").value(400))
                .andExpect(MockMvcResultMatchers.jsonPath("message")
                .value("Your age must be at least 10"));
    }

}
