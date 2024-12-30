package com.springdemo.binh97.exception;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public enum ErrorCode {
    USER_EXISTED(400,"User has been existed", HttpStatus.NOT_FOUND),
    UNAUTHORIZED_ERROR(500, "Unauthorized error", HttpStatus.UNAUTHORIZED),
    INVALID_CODE(500, "Invalid error code", HttpStatus.INTERNAL_SERVER_ERROR),
    USER_INVALID(400,"Username must be at least 3 characters long and cannot be blank.", HttpStatus.BAD_REQUEST),
    PASSWORD_INVALID(400,"Password must be at least 8 characters long, cannot be blank, and must contain at least one uppercase letter and one special character.", HttpStatus.BAD_REQUEST),
    USER_NOT_EXISTED(404,"User not found", HttpStatus.NOT_FOUND),
    UNAUTHORIZED(401,"Unauthorized", HttpStatus.UNAUTHORIZED),
    ACCESS_DENIED(403,"Access denied", HttpStatus.FORBIDDEN),
    ;

    int code;
    String message;
    HttpStatusCode statusCode;

    ErrorCode(int code, String message, HttpStatusCode statusCode) {
        this.code = code;
        this.message = message;
        this.statusCode = statusCode;
    }

}
