package com.example.mscustomer.dto.request;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
public class UpdateCustomerRequest {
    @Size(min = 2, max = 30, message = "First name length must be between 2 and 30")
    String firstName;

    @Size(min = 2, max = 30, message = "First name length must be between 2 and 30")
    String lastName;
}