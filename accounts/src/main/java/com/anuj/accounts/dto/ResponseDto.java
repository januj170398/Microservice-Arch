package com.anuj.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
public class ResponseDto {
    @Schema(description = "Schema to hold successful response information",example = "200")
    private String statusCode;
    @Schema(description = "Schema message in the response ",example ="200")
    private String statusMsg;

    public ResponseDto(String statusCode, String statusMsg) {
        this.statusCode = statusCode;
        this.statusMsg = statusMsg;
    }
}
