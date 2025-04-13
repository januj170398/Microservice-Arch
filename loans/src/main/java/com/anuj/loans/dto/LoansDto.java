package com.anuj.loans.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

@Data
@Schema(
        name = "Loans",
        description = "Schema to hold Loan information"
)
public class LoansDto {

    @Schema(
            description = "Mobile Number of Customer", example = "4365327698"
    )
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits")
    private String mobileNumber;

    @Schema(
            description = "Loan Number", example = "548732457654"
    )
    @Pattern(regexp = "(^$|[0-9]{12})", message = "Loan number must be 12 digits")
    private String loanNumber;

    @Schema(
            description = "Type of the loan", example = "Home Loan"
    )
    @NotEmpty(message = "Loan type cannot be empty")
    private String loanType;

    @Schema(
            description = "Total loan amount", example = "100000"
    )
    @Positive(message = "Total loan amount should be greater than zero")
    private int totalLoan;

    @Schema(
            description = "Total loan amount paid", example = "1000"
    )
    @PositiveOrZero(message = "Total loan amount paid should be equal or greater than zero")
    private int amountPaid;

    @Schema(
            description = "Outstanding amount against a loan", example = "99000"
    )
    @PositiveOrZero(message = "Outstanding amount should be equal or greater than zero")
    private int outstandingAmount;
}
