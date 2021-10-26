package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GuestTypeDTO {
    @NotEmpty(message = "Guest Type name is required")
    @Size(min = 3, message = "Guest Type name should have at least 3 characters")
    private String name;
}
