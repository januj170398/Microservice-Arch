package com.anuj.cards.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
@Schema(
        name = "Cards",
        description = "Schema to hold Card information"
)
public class CardsDto {

    @Schema(
            description = "Mobile Number of Customer", example = "4354437687"
    )
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits")
    private String mobileNumber;

    @Schema(
            description = "Card Number of the customer", example = "100646930341"
    )
    @NotEmpty(message = "Card number can not be null or empty")
    private String cardNumber;

    @Schema(
            description = "Type of the card", example = "Credit Card"
    )
    @NotEmpty(message = "Card type can not be null or empty")
    private String cardType;

    @Schema(
            description = "Total amount limit available against a card", example = "100000"
    )
    @Positive(message = "Total card limit should be greater than zero")
    private int totalLimit;

    @Schema(
            description = "Total amount used by a customer", example = "1000"
    )
    @Positive(message = "Amount used should be greater than zero")
    private int amountUsed;

    @Schema(
            description = "Total available amount against a card", example = "99000"
    )
    @Positive(message = "Available amount should be greater than zero")
    private int availableAmount;
}
