package com.example.mscustomer.dto.response;

import com.example.mscustomer.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

import static lombok.AccessLevel.PRIVATE;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
@Builder
public class CustomerResponse {
    Long id;
    String firstName;
    String lastName;
    Status status;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
}