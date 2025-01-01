package com.orangesoft.order_service.dto;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public record ErrorResponse(String apiPath, String message, HttpStatus status, LocalDateTime errorTime) {
}
