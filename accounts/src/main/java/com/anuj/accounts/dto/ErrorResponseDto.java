package com.anuj.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data @Schema(
        name = "ErrorResponse",
        description = "Schema to hold error response information"
)
public class ErrorResponseDto {
    @Schema(
            description = "API path invoked by client"
    )
    private String apiPath;
    private LocalDateTime errorTime;
    @Schema(
            description = "Error code representing the error happened"
    )
    private HttpStatus errorCode;
    @Schema(
            description = "Time Error code representing the error happened"
    )
    private String errorMessage;

    public ErrorResponseDto(String apiPath, LocalDateTime errorTime, HttpStatus errorCode, String errorMessage) {
        this.apiPath = apiPath;
        this.errorTime = errorTime;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}