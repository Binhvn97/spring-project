package com.springdemo.binh97.controller;

import com.nimbusds.jose.JOSEException;
import com.springdemo.binh97.dto.request.AuthenticationRequest;
import com.springdemo.binh97.dto.request.InspectRequest;
import com.springdemo.binh97.dto.request.LogoutRequest;
import com.springdemo.binh97.dto.response.ApiResponse;
import com.springdemo.binh97.dto.response.AuthenticationResponse;
import com.springdemo.binh97.dto.response.InspectResponse;
import com.springdemo.binh97.service.AuthenticationService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationController {
    AuthenticationService authenticationService;

    @PostMapping("/login")
    ApiResponse<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
        var result = authenticationService.authenticate(request);
        return ApiResponse.<AuthenticationResponse>builder()
                .code(200)
                .message("Success")
                .result(result)
                .build();
    }

    @PostMapping("/verify-token")
    ApiResponse<InspectResponse> inspectToken(@RequestBody InspectRequest request)
            throws ParseException, JOSEException {
        var result = authenticationService.inspect(request);
        return ApiResponse.<InspectResponse>builder()
                .code(200)
                .result(result)
                .build();
    }

    @PostMapping("/logout")
    ApiResponse<Void> logout(@RequestBody LogoutRequest request) throws ParseException, JOSEException {
        authenticationService.logout(request);
        return ApiResponse.<Void>builder()
                .code(200)
                .build();
    }
}
