package com.example.demo.dto;

import com.example.demo.dto.response.ResponseGuestDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChildGuestDTO {
    @NotEmpty(message = "Child First Name is required")
    private String firstName;
    @NotEmpty(message = "Child Last Name is required")
    private String lastName;
    private ResponseGuestDTO guest;
}
