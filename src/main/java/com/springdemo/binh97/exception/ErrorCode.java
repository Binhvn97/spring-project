package com.springdemo.binh97.exception;

public enum ErrorCode {
    USER_EXISTED(400,"User has been existed"),
    UNAUTHORIZED_ERROR(500, "Unauthorized error"),
    INVALID_CODE(500, "Invalid error code"),
    USER_INVALID(400,"Username must be at least 3 characters long and cannot be blank."),
    PASSWORD_INVALID(400,"Password must be at least 8 characters long, cannot be blank, and must contain at least one uppercase letter and one special character."),
    USER_NOT_EXISTED(404,"User not found"),
    UNAUTHORIZED(401,"Unauthorized")
    ;

    private int code;
    private String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
