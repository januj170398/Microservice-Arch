package com.anuj.accounts.dto;

import com.anuj.accounts.enums.AccountType;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "Accounts", description = "Schema to hold Account information")
public class AccountsDto {

    @NotNull(message = "AccountNumber cannot be null")
    @Schema(
            description = "Account Number of Eazy Bank account", example = "3454433243"
    )
    @Pattern(regexp = "^[0-9]{10}$", message = "Account number must be exactly 10 digits")
    private Long accountNumber;

    @NotNull(message = "AccountType cannot be null")
    @Schema(
            description = "Account type of Eazy Bank account", example = "SAVINGS"
    )
    private AccountType accountType;

    @NotEmpty(message = "BranchAddress cannot be null or empty")
    @Pattern(regexp = "^[\\w\\s,.-]{5,100}$", message = "Branch address must be between 5 and 100 characters and can only contain letters, numbers, spaces, and basic punctuation")
    @Schema(
            description = "Eazy Bank branch address", example = "123 Wall Street, New York"
    )
    private String branchAddress;
}