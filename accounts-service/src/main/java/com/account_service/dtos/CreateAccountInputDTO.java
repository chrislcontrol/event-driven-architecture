package com.account_service.dtos;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class CreateAccountInputDTO {
    @Positive
    @Min(value = 1, message = "The branch value must be greater than or equal to 1.")
    private long branch;
}
